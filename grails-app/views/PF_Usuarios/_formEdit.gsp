<%@ page import="pf4gl.PF_Usuarios" %>



<div class="fieldcontain ${hasErrors(bean: PF_UsuariosInstance, field: 'apellido', 'error')} ">
	<label for="apellido">
		<g:message code="PF_Usuarios.apellido.label" default="Apellido" />
		
	</label>
	<g:textField name="apellido" value="${PF_UsuariosInstance?.apellido}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_UsuariosInstance, field: 'celular', 'error')} ">
	<label for="celular">
		<g:message code="PF_Usuarios.celular.label" default="Celular" />
		
	</label>
	<g:textField name="celular" value="${PF_UsuariosInstance?.celular}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_UsuariosInstance, field: 'correo', 'error')} ">
	<label for="correo">
		<g:message code="PF_Usuarios.correo.label" default="Correo" />
		
	</label>
	<g:textField name="correo" value="${PF_UsuariosInstance?.correo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_UsuariosInstance, field: 'nick', 'error')} ">
	<label for="nick">
		<g:message code="PF_Usuarios.nick.label" default="Nick" />
		
	</label>
	<g:textField name="nick" value="${PF_UsuariosInstance?.nick}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_UsuariosInstance, field: 'nombre', 'error')} ">
	<label for="nombre">
		<g:message code="PF_Usuarios.nombre.label" default="Nombre" />
		
	</label>
	<g:textField name="nombre" value="${PF_UsuariosInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_UsuariosInstance, field: 'password', 'error')} ">
	<label for="password">
		<g:message code="PF_Usuarios.password.label" default="Password" />
		
	</label>
	<g:passwordField name="password" value="${PF_UsuariosInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_UsuariosInstance, field: 'roles', 'error')} ">
	<label for="roles">
		<g:message code="PF_Usuarios.roles.label" default="Roles" />
		
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: PF_UsuariosInstance, field: 'telefono', 'error')} ">
	<label for="telefono">
		<g:message code="PF_Usuarios.telefono.label" default="Telefono" />
		
	</label>
	<g:textField name="telefono" value="${PF_UsuariosInstance?.telefono}"/>
</div>

