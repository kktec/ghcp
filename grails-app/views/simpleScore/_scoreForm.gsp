<div class="fieldcontain message">* indicates a required entry</div>
<g:hasErrors bean="${score}">
    <div class="errors"><g:renderErrors bean="${score}" /></div>
</g:hasErrors>
<div id="score_form">
    <fieldset class="form">
        <div class="fieldcontain ${hasErrors(bean: score, field: 'playedOn', 'errors') }">
          <label for="playedOn">Date:<span class="required-indicator">*</span></label>
          <g:textField name="playedOn" maxLength="10" size="10" required="required" value="${score.playedOn}"/>
        </div>
        <div class="fieldcontain ${hasErrors(bean: score, field: 'strokes', 'errors') }">
          <label for="strokes">Strokes:<span class="required-indicator">*</span></label>
          <input type="number" name="strokes" min="54" max="199" required="required" value="${score.strokes}"/>
        </div>
        <div class="fieldcontain ${hasErrors(bean: score, field: 'rating', 'errors') }"">
          <label for="rating">USGA Rating:<span class="required-indicator">*</span></label>
          <g:textField type="text" name="rating" maxLength="4" size="4" required="required" value="${score.rating}"/>
        </div>
        <div class="fieldcontain ${hasErrors(bean: score, field: 'slope', 'errors') }"">
          <label for="slope">Slope:<span class="required-indicator">*</span></label>
          <input type="number" name="slope" min="80" max="199" required="required" value="${score.slope}"/>
        </div>
    </fieldset>
</div>
