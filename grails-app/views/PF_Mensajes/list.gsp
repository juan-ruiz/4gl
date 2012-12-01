
<%@ page import="pf4gl.PF_Mensajes" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'PF_Mensajes.label', default: 'PF_Mensajes')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-PF_Mensajes" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-PF_Mensajes" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="PF_Mensajes.destinatario.label" default="Destinatario" /></th>
					
						<g:sortableColumn property="mensaje" title="${message(code: 'PF_Mensajes.mensaje.label', default: 'Mensaje')}" />
					
						<th><g:message code="PF_Mensajes.remitente.label" default="Remitente" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${PF_MensajesInstanceList}" status="i" var="PF_MensajesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${PF_MensajesInstance.id}">${fieldValue(bean: PF_MensajesInstance, field: "destinatario")}</g:link></td>
					
						<td>${fieldValue(bean: PF_MensajesInstance, field: "mensaje")}</td>
					
						<td>${fieldValue(bean: PF_MensajesInstance, field: "remitente")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${PF_MensajesInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
