<%@ page import="pf4gl.PF_Roles" %>



<div class="fieldcontain ${hasErrors(bean: PF_RolesInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="PF_Roles.nombre.label" default="Nombre" />
		
	</label>
	<g:textField name="nombre" value="${PF_RolesInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_RolesInstance, field: 'usuarios', 'error')} ">
	<label for="usuarios">
		<g:message code="PF_Roles.usuarios.label" default="Usuarios" />
		
	</label>
	<g:select name="usuarios" from="${pf4gl.PF_Usuarios.list()}" multiple="multiple" optionKey="id" size="5" value="${PF_RolesInstance?.usuarios*.id}" class="many-to-many"/>
</div>

