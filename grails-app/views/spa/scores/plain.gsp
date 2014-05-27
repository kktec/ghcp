<!DOCTYPE html>
<html>
    <head>
        <title>Golf Handicap Tracker</title>
        <meta name="layout" content="main">
        
        <asset:javascript src="jquery_plugins/jquery.dataTables.js"/>
        <asset:javascript src="scoresDataTable.js"/>
    </head>
    <body>
        <div><h1>Handicap Index: ${handicap}</h1></div>
        <div>
          <h1>Scores:</h1>
          <g:render template="scores/scores" />
        </div>
    </body>
</html>
