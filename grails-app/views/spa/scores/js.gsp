<!DOCTYPE html>
<html>
    <head>
        <title>Golf Handicap Tracker</title>
        <meta name="layout" content="main">
        
        <asset:javascript src="jquery_plugins/jquery.dataTables.js"/>
        <asset:javascript src="scores_js.js"/>
    </head>
    <body>
        <div><h1>Handicap Index: <span id="handicap">${handicap}</span></h1></div>
        <div>
          <h1>Scores:</h1>
          <table id="table"><g:render template="scores/head" /></table>
        </div>
    </body>
</html>
