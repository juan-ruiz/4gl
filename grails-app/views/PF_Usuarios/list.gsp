
<%@ page import="pf4gl.PF_Usuarios" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'PF_Usuarios.label', default: 'PF_Usuarios')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-PF_Usuarios" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-PF_Usuarios" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="apellido" title="${message(code: 'PF_Usuarios.apellido.label', default: 'Apellido')}" />
					
						<g:sortableColumn property="celular" title="${message(code: 'PF_Usuarios.celular.label', default: 'Celular')}" />
					
						<g:sortableColumn property="correo" title="${message(code: 'PF_Usuarios.correo.label', default: 'Correo')}" />
					
						<g:sortableColumn property="nick" title="${message(code: 'PF_Usuarios.nick.label', default: 'Nick')}" />
					
						<g:sortableColumn property="nombre" title="${message(code: 'PF_Usuarios.nombre.label', default: 'Nombre')}" />
					
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${PF_UsuariosInstanceList}" status="i" var="PF_UsuariosInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${PF_UsuariosInstance.id}">${fieldValue(bean: PF_UsuariosInstance, field: "apellido")}</g:link></td>
					
						<td>${fieldValue(bean: PF_UsuariosInstance, field: "celular")}</td>
					
						<td>${fieldValue(bean: PF_UsuariosInstance, field: "correo")}</td>
					
						<td>${fieldValue(bean: PF_UsuariosInstance, field: "nick")}</td>
					
						<td>${fieldValue(bean: PF_UsuariosInstance, field: "nombre")}</td>
					
						
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${PF_UsuariosInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
