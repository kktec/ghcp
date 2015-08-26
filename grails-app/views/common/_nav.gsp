<ul>
    <li>
        <g:if test="${view == 'plain' }"><strong>Plain html/gsp</strong></g:if>
        <g:else><g:link controller="score" action="index" class="btn">Plain html/gsp</g:link></g:else>
    </li>
    <li>
        <g:if test="${view == 'ko' }"><strong>Knockout SPA</strong></g:if>
        <g:else><g:link controller="score" action="ko" class="btn">Knockout SPA</g:link></g:else>
    </li>
    <li>
        <g:if test="${view == 'kobs' }"><strong>Knockout SPA w/Bootstrap</strong></g:if>
        <g:else><g:link controller="score" action="kobs" class="btn">Knockout SPA w/Bootstrap</g:link></g:else>
    </li>
</ul>
