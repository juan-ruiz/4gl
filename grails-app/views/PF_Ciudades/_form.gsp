<%@ page import="pf4gl.PF_Ciudades" %>



<div class="fieldcontain ${hasErrors(bean: PF_CiudadesInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="PF_Ciudades.nombre.label" default="Nombre" />
		
	</label>
	<g:textField name="nombre" value="${PF_CiudadesInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_CiudadesInstance, field: 'pais', 'error')} required">
	<label for="pais">
		<g:message code="PF_Ciudades.pais.label" default="Pais" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="pais" name="pais.id" from="${pf4gl.PF_Paises.list()}" optionKey="id" required="" value="${PF_CiudadesInstance?.pais?.id}" class="many-to-one"/>
</div>

