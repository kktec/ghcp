<%@ page import="org.kktec.ghcp.Score" %>



<div class="fieldcontain ${hasErrors(bean: scoreInstance, field: 'strokes', 'error')} required">
	<label for="strokes">
		<g:message code="score.strokes.label" default="Strokes" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="strokes" type="number" min="54" max="199" value="${scoreInstance.strokes}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: scoreInstance, field: 'rating', 'error')} required">
	<label for="rating">
		<g:message code="score.rating.label" default="Rating" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="rating" value="${fieldValue(bean: scoreInstance, field: 'rating')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: scoreInstance, field: 'slope', 'error')} required">
	<label for="slope">
		<g:message code="score.slope.label" default="Slope" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="slope" type="number" min="55" max="175" value="${scoreInstance.slope}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: scoreInstance, field: 'playedOn', 'error')} required">
	<label for="playedOn">
		<g:message code="score.playedOn.label" default="Played On" />
		<span class="required-indicator">*</span>
	</label>
	

</div>

