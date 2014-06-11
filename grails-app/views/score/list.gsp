<!DOCTYPE html>
<html>
    <head>
        <title>Golf Handicap Tracker</title>
        <meta name="layout" content="main">
        <asset:javascript src="jqp/jquery.dataTables.js"/>
        <asset:stylesheet src="jquery.dataTables.css"/>
        <asset:javascript src="scores.js"/>
    </head>
    <body>
        <g:render template="/common/flash" />
        <h1>Handicap Index: <span id="handicap">${handicapRecord.handicap}</span></h1>
        <g:if test="${!handicapRecord.handicap}"><div class="fieldcontain message">A minimum of 5 scores is needed to calculate a handicap !</div></g:if>
        <h1>Scores:</h1>
        <div id="dt"><g:render template="scores" /></div>
        <div class="nav">
            <ul>
                <li><g:link controller="score" action="create" >Add Score</g:link></li>
            </ul>
        </div>
    </body>
</html>
