
<%@ page import="org.kktec.ghcp.Score" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'score.label', default: 'Score')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-score" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-score" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list score">
			
				<g:if test="${scoreInstance?.strokes}">
				<li class="fieldcontain">
					<span id="strokes-label" class="property-label"><g:message code="score.strokes.label" default="Strokes" /></span>
					
						<span class="property-value" aria-labelledby="strokes-label"><g:fieldValue bean="${scoreInstance}" field="strokes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${scoreInstance?.rating}">
				<li class="fieldcontain">
					<span id="rating-label" class="property-label"><g:message code="score.rating.label" default="Rating" /></span>
					
						<span class="property-value" aria-labelledby="rating-label"><g:fieldValue bean="${scoreInstance}" field="rating"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${scoreInstance?.slope}">
				<li class="fieldcontain">
					<span id="slope-label" class="property-label"><g:message code="score.slope.label" default="Slope" /></span>
					
						<span class="property-value" aria-labelledby="slope-label"><g:fieldValue bean="${scoreInstance}" field="slope"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${scoreInstance?.playedOn}">
				<li class="fieldcontain">
					<span id="playedOn-label" class="property-label"><g:message code="score.playedOn.label" default="Played On" /></span>
					
						<span class="property-value" aria-labelledby="playedOn-label"><g:fieldValue bean="${scoreInstance}" field="playedOn"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:scoreInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${scoreInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
