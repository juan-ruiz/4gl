<%@ page import="pf4gl.PF_Servicios" %>



<div class="fieldcontain ${hasErrors(bean: PF_ServiciosInstance, field: 'descripcion', 'error')} ">
	<label for="descripcion">
		<g:message code="PF_Servicios.descripcion.label" default="Descripcion" />
		
	</label>
	<g:textField name="descripcion" value="${PF_ServiciosInstance?.descripcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_ServiciosInstance, field: 'inmuebles', 'error')} ">
	<label for="inmuebles">
		<g:message code="PF_Servicios.inmuebles.label" default="Inmuebles" />
		
	</label>
	<g:select name="inmuebles" from="${pf4gl.PF_Inmuebles.list()}" multiple="multiple" optionKey="id" size="5" value="${PF_ServiciosInstance?.inmuebles*.id}" class="many-to-many"/>
</div>

