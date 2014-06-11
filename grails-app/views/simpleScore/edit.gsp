<!DOCTYPE html>
<html>
    <head>
        <title>Change Score - Golf Handicap Tracker</title>
        <meta name="layout" content="main">
        <asset:javascript src="jqp/jquery-ui-1.10.4.custom.js"/>
        <asset:stylesheet href="ui-lightness/jquery-ui-1.10.4.custom.css"/>
        <asset:javascript src="scoreForm.js"/>
    </head>
    <body>
        <h1>Change Score:</h1>
        <g:form action="update">
            <g:hiddenField name="id" value="${score.id}" />
            <g:render template="scoreForm" />
            <fieldset class="buttons">
                <g:submitButton name="update" value="Update" />
            </fieldset>
        </g:form>
    </body>
</html>
