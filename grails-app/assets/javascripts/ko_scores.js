var dp = {
	dateFormat: "yy-mm-dd",
	autoSize: true,
	showOtherMonths: true,
	selectOtherMonths: true	
};

function println(message) {
	console.log('' + message);
}

function required(label) {
	return label + ' is required';
}

function localDate(date) {
	return new Date(date.getYear() + 1900, date.getMonth(), date.getDate());
}

function Score(score) {
	var self = this;
	
	self.id = ko.observable(score.id);
	self.strokes = ko.observable(score.strokes);
	self.rating = ko.observable(score.rating);
	self.slope = ko.observable(score.slope);
	self.playedOn = ko.observable(score.playedOn);
	self.differential = ko.observable(score.differential);
	self.used = ko.observable(score.used);
	self.errors = ko.observableArray(score.errors);
	
	self.isValid = function() {
		var errors = [];
		
		var playedOn = ko.unwrap(self.playedOn());
		if(!playedOn) {
			errors.push({ message: required('Played On'), field: 'playedOn' });
		}
		else {
	        var today = localDate(new Date());
	        if (playedOn - today > 0) {
        			errors.push({ message: 'Played On may not be a future date', field: 'playedOn' });
	        }
		}
		
		if(!self.strokes()) {
			errors.push({ message: required('Strokes'), field: 'strokes' });
		}
		
		var rating = self.rating();
		if(!rating) {
			errors.push({ message: required('USGA Rating'), field: 'rating' });
		}
		
		var usgaRating = parseFloat(rating);
		if(usgaRating < 60.0) { 
			errors.push({ message: 'USGA Rating must be at least 60.0', field: 'rating' });
		}
		else if(usgaRating > 89.9) {
			errors.push({ message: 'USGA Rating must be at most 89.9', field: 'rating' });
		}
		
		if(!self.slope()) {
			errors.push({ message: required('Slope'), field: 'slope' });
		};
		
		self.errors(errors);
		return errors.length < 1;
	};
}

function HandicapRecord() {
	var self = this;
	
	self.message = ko.observable('');
	self.handicap = ko.observable();
	self.scores = ko.observableArray([]);
	self.selectedScore = ko.observable();
	self.editing = ko.observable(false);
	
	self.add = function() {
		var score = new Score({
			id: null,
			strokes: null,
			rating: null,
			slope: 113,
			playedOn: null,
			differential: null,
			used: false,
			errors: []
		});
		score.isValid();
		self.selectedScore(score);
		self.editing(true);
	};
	
	self.edit = function(score) {
		self.selectedScore(score);
		self.editing(true);
	};
	
	self.delete = function(score) {
		var id = ko.unwrap(score.id);
		console.log('delete ' + id);
		var prompt = 'Are you sure you want to delete the score ' + score.strokes() + ' played on ' + score.playedOn() + ' ?';
		if(confirm(prompt)) {
			self.deleteScore(id);
		}
	}
	
	self.save = function() {
		var score = self.selectedScore();
		if(score.isValid()) {
			self.saveScore(score);
		}
		else {
			score.errors().push({ message: 'score has errors' });
		}
	};
	
	self.cancel = function() {
		self.editing(false);
		self.selectedScore(null);
	};
	
	self.saveScore = function() {
		var score = self.selectedScore();
		var id = score.id();
		var action = id ? 'update' : 'save';
		$.ajax({
			type: 'POST',
			url: "/ghcp/api/scores/" + action,
			data: ko.toJS(score)
		})
		.complete(function(jqxhr, textStatus) {
			var message = id ? 'Updated Score ' + id : 'New Score added'
			self.load(message);
		})
		.error(function(jqxhr, textStatus, error) {
			self.selectedScore().errors.push({ message: 'An error occured while saving the Score: ' + error });
		});
	}
	
	self.deleteScore = function(id) {
		$.ajax({
			type: 'POST',
			url: "/ghcp/api/scores/delete",
			data: { id: id }
		})
		.complete(function(jqxhr, textStatus) {
			self.load('Deleted Score ' + id);
		})
		.error(function(jqxhr, textStatus, error) {
			println('error');
			self.message('An error occured while deleting Score ' + id + ': ' + error);
		});
	}
	
	self.load = function(message) {
		$.getJSON("/ghcp/api/scores/handicapRecord", function(data) {
			self.handicap(data.handicap);
			self.message((data.scores.length < 5 ? 'A minimum of 5 scores is needed to calculate a handicap !' : ''));
			var scores = $.map(data.scores, function(score) { 
				return new Score(score)
			});
			self.scores(scores);
			self.editing(false);
			self.selectedScore(null);
			self.message(message);
		})
		.fail(function(jqxhr, textStatus, error) {
			self.message('An error occured while loading the Handicap Record: ' + error);
		});
	};
	
	self.load();
}

ko.bindingHandlers.datepicker = {
    init: function(element, valueAccessor) {
        $(element).datepicker(dp);
        var date = ko.unwrap(valueAccessor());
        $(element).datepicker("setDate", date);        
        valueAccessor(Date.parse(date));
        
        //handle the field changing
        ko.utils.registerEventHandler(element, "change", function() {
        		var dateAccessor = valueAccessor();
        		var date = $(element).datepicker("getDate")
            dateAccessor(Date.parse(date));
        });
    },
    
    update: function(element, valueAccessor, allBindings, viewModel, bindingContext) {
        var value = ko.unwrap(valueAccessor());
		var parent = bindingContext.$parent
        parent.selectedScore().isValid();
        
        var today = localDate(new Date());
        if (value - today > 0) {
            $(element).datepicker("setDate", '');
            $(element).blur();
        }
        else {
            $(element).datepicker("setDate", value);
            $('#strokes').focus();
        }
    }
};

var record = new HandicapRecord();
ko.applyBindings(record);

