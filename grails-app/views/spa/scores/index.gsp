<!DOCTYPE html>
<html>
    <head>
        <title>Golf Handicap Tracker</title>
        <meta name="layout" content="main">
    </head>
    <body>
        <div><h1>Handicap Index: ${handicap}</h1></div>
        <div>
          <h1>Scores:</h1>
          <table id="table">
              <thead>
                  <tr>
                      <th>Strokes</th>
                      <th>Rating</th>
                      <th>Slope</th>
                      <th>Played On</th>
                      <th>Differential</th>
                  </tr>
              </thead>
              <tbody>
                  <g:each in="${scores}" var="s">
                  <tr>
                      <td>${s.strokes}</td>    
                      <td>${s.rating}</td>    
                      <td>${s.slope}</td>    
                      <td>${s.playedOn}</td>    
                      <td>${s.differential}</td>    
                  </tr>
                  </g:each>
              </tbody>
          </table>
        </div>
    </body>
</html>
