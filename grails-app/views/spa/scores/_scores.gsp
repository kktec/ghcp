<table id="table">
    <g:render template="scores/head" />
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
