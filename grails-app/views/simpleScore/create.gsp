<!DOCTYPE html>
<html>
    <head>
        <title>Add Score - Golf Handicap Tracker</title>
        <meta name="layout" content="main">
        <asset:javascript src="jqp/jquery-ui-1.10.4.custom.js"/>
        <asset:stylesheet href="ui-lightness/jquery-ui-1.10.4.custom.css"/>
        <asset:javascript src="scoreForm.js"/>
    </head>
    <body>
        <h1>Add Score:</h1>
        <g:form action="save">
            <g:render template="scoreForm" />
            <fieldset class="buttons">
                <g:submitButton name="add" value="Add" />
            </fieldset>
        </g:form>
    </body>
</html>
