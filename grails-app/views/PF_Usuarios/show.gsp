
<%@ page import="pf4gl.PF_Usuarios" %>
<!DOCTYPE html>
<html>
	<head>
           <style type="text/css">
            #grailsLogo {
	background-color: #000000;
}
.footer {
  
  background-color: #000000;
  
  
}
             
            </style>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'PF_Usuarios.label', default: 'PF_Usuarios')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-PF_Usuarios" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-PF_Usuarios" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list PF_Usuarios">
			
				<g:if test="${PF_UsuariosInstance?.apellido}">
				<li class="fieldcontain">
					<span id="apellido-label" class="property-label"><g:message code="PF_Usuarios.apellido.label" default="Apellido" /></span>
					
						<span class="property-value" aria-labelledby="apellido-label"><g:fieldValue bean="${PF_UsuariosInstance}" field="apellido"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_UsuariosInstance?.celular}">
				<li class="fieldcontain">
					<span id="celular-label" class="property-label"><g:message code="PF_Usuarios.celular.label" default="Celular" /></span>
					
						<span class="property-value" aria-labelledby="celular-label"><g:fieldValue bean="${PF_UsuariosInstance}" field="celular"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_UsuariosInstance?.correo}">
				<li class="fieldcontain">
					<span id="correo-label" class="property-label"><g:message code="PF_Usuarios.correo.label" default="Correo" /></span>
					
						<span class="property-value" aria-labelledby="correo-label"><g:fieldValue bean="${PF_UsuariosInstance}" field="correo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_UsuariosInstance?.nick}">
				<li class="fieldcontain">
					<span id="nick-label" class="property-label"><g:message code="PF_Usuarios.nick.label" default="Nick" /></span>
					
						<span class="property-value" aria-labelledby="nick-label"><g:fieldValue bean="${PF_UsuariosInstance}" field="nick"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_UsuariosInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="PF_Usuarios.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${PF_UsuariosInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_UsuariosInstance?.id}">
				<li class="fieldcontain">
					<span id="id-label" class="property-label"><g:message code="PF_Usuarios.id.label" default="Cedula" /></span>
					
						<span class="property-value" aria-labelledby="id-label"><g:fieldValue bean="${PF_UsuariosInstance}" field="id"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_UsuariosInstance?.roles}">
				<li class="fieldcontain">
					<span id="roles-label" class="property-label"><g:message code="PF_Usuarios.roles.label" default="Roles" /></span>
					
						<g:each in="${PF_UsuariosInstance.roles}" var="r">
						<span class="property-value" aria-labelledby="roles-label"><g:link controller="PF_Roles" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${PF_UsuariosInstance?.telefono}">
				<li class="fieldcontain">
					<span id="telefono-label" class="property-label"><g:message code="PF_Usuarios.telefono.label" default="Telefono" /></span>
					
						<span class="property-value" aria-labelledby="telefono-label"><g:fieldValue bean="${PF_UsuariosInstance}" field="telefono"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${PF_UsuariosInstance?.id}" />
					<g:link class="edit" action="edit" id="${PF_UsuariosInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
