<table id="table">
    <thead><g:render template="head" /></thead>
    <tbody>
        <g:each in="${handicapRecord.scores}" var="s">
        <tr>
            <td>${s.strokes}</td>    
            <td>${s.rating}</td>    
            <td>${s.slope}</td>    
            <td>${s.playedOn}</td>    
            <td>${s.differential}</td>  
            <td>${s.used ? '*' : ''}</td>    
            <td><g:link action="edit" id="${s.id}">Change</g:link></td>
            <td>
                <g:form>
                    <g:hiddenField name="id" value="${s.id}" />
                    <g:actionSubmit value="delete" value="Delete" onclick="return confirm('Are you sure you want to delete the score ${s.strokes} played on ${s.playedOn} ?');" />
                </g:form>
            </td>
        </tr>
        </g:each>
    </tbody>
</table>
