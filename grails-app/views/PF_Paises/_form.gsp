<%@ page import="pf4gl.PF_Paises" %>



<div class="fieldcontain ${hasErrors(bean: PF_PaisesInstance, field: 'nomre', 'error')} ">
	<label for="nomre">
		<g:message code="PF_Paises.nomre.label" default="Nomre" />
		
	</label>
	<g:textField name="nomre" value="${PF_PaisesInstance?.nomre}"/>
</div>

