var ghcp = {}

$(function() {
	function HandicapRecord() {
		var self = this;
		
		self.message = ko.observable("");
		self.handicap = ko.observable();
		self.scores = ko.observableArray([]);
		self.selectedScore = ko.observable();
	}
	
	var record = new HandicapRecord();
	ko.applyBindings(record);
//	ghcp.record = record;
	
	function fetch() {
		$.getJSON("/ghcp/api/scores/handicapRecord", function(data) {
			record.handicap(data.handicap);
			record.scores(data.scores);
			record.message((record.scores().length < 5 ? 'A minimum of 5 scores is needed to calculate a handicap !' : ''));
		}).done(function(data) {
			console.log('h = ' + record.handicap());
		}).fail(function() {
			console.log('fetch error');
		});
	}

	fetch();
});


//$(function ghcp() {
//	function HandicapRecord() {
//		var self = this;
//		
//		self.scores = ko.observableArray([]);
//		self.handicap = ko.observable("");
//		self.score = ko.observable("");
//	}
//	ghcp.HandicapRecord = HandicapRecord;
//	
//	function Score() {
//		var self = this;
//		
//		self.strokes = ko.observable("");
//		self.rating = ko.observable("");
//		self.slope =  ko.observable("");
//		self.playedOn = ko.observable("");
//		self.differential = ko.observable("");
//		self.used = ko.observable("");
//	}
//	ghcp.Score = Score;
//
//	function fetch() {
//		$.getJSON("/ghcp/api/scores/handicapRecord", function(data) {
//			ghcp.data = data;
//		}).done(function(data) {
//			ghcp.handicapRecord = data;
//			console.log('hcp = ' +  ghcp.handicapRecord.handicap);
//		}).fail(function() {
//			console.log('fetch error');
//		});
//	}
//	ghcp.fetch = fetch;
//
//	ghcp.fetch();
//
//});





