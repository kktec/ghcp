<!DOCTYPE html>
<html>
    <head>
        <title>KO - Golf Handicap Tracker</title>
        <meta name="layout" content="main">
        <asset:javascript src="knockout-3.1.0.debug.js"/>
<%--        <asset:javascript src="knockout.mapping-2.4.1.latest.debug.js"/>--%>
        <asset:javascript src="jqp/jquery-ui-1.10.4.custom.js"/>
        <asset:stylesheet href="ui-lightness/jquery-ui-1.10.4.custom.css"/>
    </head>
    <body>
        <div id="handicapRecordView" data-bind="visible: !editing()">
          <p><button data-bind="click: add">Add Score</button></p>
          <h1>Handicap Index: <span data-bind="text: handicap"></span></h1>
          <div class="fieldcontain message" data-bind="visible: message, text: message"></div>
          <h1>Scores:</h1>
          <table id="table">
              <thead>
                  <tr>
                      <th>Id</th>
                      <th>Strokes</th>
                      <th>Rating</th>
                      <th>Slope</th>
                      <th>Played On</th>
                      <th>Differential</th>
                      <th>Used</th>
                      <th></th>
                      <th></th>
                  </tr>
              </thead>
              <tbody data-bind="foreach: scores">
                <tr>
                   <td data-bind="text: id"></td>    
                   <td data-bind="text: strokes"></td>    
                   <td data-bind="text: rating"></td>    
                   <td data-bind="text: slope"></td>    
                   <td data-bind="text: playedOn"></td>    
                   <td data-bind="text: differential"></td>    
                   <td data-bind="text: used ? '*' : ''"></td> 
                   <td><button data-bind="click: $parent.edit">Change</button></td>   
                   <td><button data-bind="click: $parent.delete">Delete</button></td>   
                </tr>    
              </tbody>
          </table>
        </div>
        <div data-bind="visible: editing()">
            <h1>Score:</h1>
            <div class="fieldcontain message">* indicates a required entry</div>
            <div data-bind="with: selectedScore">
                <ul class="errors" data-bind="visible: errors().length > 0, foreach: errors">
                    <li data-bind="text: message"></li>
                </ul>
                <fieldset class="form">
                    <input type="hidden" name="id" data-bind="value: id"/>
                    <div class="fieldcontain">
                      <label for="playedOn">Played On:<span class="required-indicator">*</span></label>
                      <input name="playedOn" maxLength="10" size="10" required="required" data-bind="datepicker: playedOn"/>
                    </div>
                    <div class="fieldcontain">
                      <label for="strokes">Strokes:<span class="required-indicator">*</span></label>
                      <input type="number" id="strokes" name="strokes" min="54" max="199" required="required" data-bind="value: strokes"/>
                    </div>
                    <div class="fieldcontain">
                      <label for="rating">USGA Rating:<span class="required-indicator">*</span></label>
                      <input type="text" name="rating" maxLength="4" size="4" required="required" data-bind="value: rating"/>
                    </div>
                    <div class="fieldcontain">
                      <label for="slope">Slope:<span class="required-indicator">*</span></label>
                      <input type="number" name="slope" min="80" max="199" required="required" data-bind="value: slope"/>
                    </div>
               </fieldset>
               <fieldset class="buttons">
                    <button data-bind="click: $parent.save">Save</button>
                    <label></label>
                    <button data-bind="click: $parent.cancel">Cancel</button>
               </fieldset>
            </div>
        </div>
        <div>
            <h1>Debug:</h1>
            <p data-bind="text: ko.toJSON($data)"></p>
        </div>
        <asset:javascript src="ko_scores.js"/>
    </body>
</html>
