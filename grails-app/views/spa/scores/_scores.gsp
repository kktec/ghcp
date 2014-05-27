<table id="table">
    <thead>
        <tr>
            <th>Strokes</th>
            <th>Rating</th>
            <th>Slope</th>
            <th>Played On</th>
            <th>Differential</th>
        </tr>
    </thead>
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
