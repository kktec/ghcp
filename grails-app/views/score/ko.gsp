<!DOCTYPE html>
<html>
    <head>
        <title>KO - Golf Handicap Tracker</title>
        <meta name="layout" content="main">
        <asset:javascript src="knockout-3.1.0.debug.js"/>
<%--        <asset:javascript src="knockout.mapping-2.4.1.latest.debug.js"/>--%>
    </head>
    <body>
        <div id="handicapRecordView">
          <h1>Handicap Index: <span data-bind="text: handicap"></span></h1>
          <div class="fieldcontain message" data-bind="visible: message === '', text: message"></div>
          <p><button data-bind="visible: selectedScore() !== undefined">Add Score</button></p>
          <h1>Scores:</h1>
          <table id="table">
              <thead>
                  <tr>
                      <th>Strokes</th>
                      <th>Rating</th>
                      <th>Slope</th>
                      <th>Played On</th>
                      <th>Differential</th>
                      <th>Used</th>
                  </tr>
              </thead>
              <tbody data-bind="foreach: scores">
                <tr>
                   <td data-bind="text: strokes"></td>    
                   <td data-bind="text: rating"></td>    
                   <td data-bind="text: slope"></td>    
                   <td data-bind="text: playedOn"></td>    
                   <td data-bind="text: differential"></td>    
                   <td data-bind="text: used ? '*' : ''"></td>    
                </tr>    
              </tbody>
          </table>
        </div>
        <div>
            <h1>Debug:</h1>
            <p data-bind="text: ko.toJSON($data)"></p>
        </div>
        <asset:javascript src="ko_scores.js"/>
    </body>
</html>
