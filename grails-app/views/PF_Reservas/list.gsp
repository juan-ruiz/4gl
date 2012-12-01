
<%@ page import="pf4gl.PF_Reservas" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'PF_Reservas.label', default: 'PF_Reservas')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-PF_Reservas" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-PF_Reservas" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="estado" title="${message(code: 'PF_Reservas.estado.label', default: 'Estado')}" />
					
						<g:sortableColumn property="fechaLlegada" title="${message(code: 'PF_Reservas.fechaLlegada.label', default: 'Fecha Llegada')}" />
					
						<g:sortableColumn property="fechaSalida" title="${message(code: 'PF_Reservas.fechaSalida.label', default: 'Fecha Salida')}" />
					
						<th><g:message code="PF_Reservas.inmueble.label" default="Inmueble" /></th>
					
						<g:sortableColumn property="numeroHuspedes" title="${message(code: 'PF_Reservas.numeroHuspedes.label', default: 'Numero Huspedes')}" />
					
						<th><g:message code="PF_Reservas.usuario.label" default="Usuario" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${PF_ReservasInstanceList}" status="i" var="PF_ReservasInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${PF_ReservasInstance.id}">${fieldValue(bean: PF_ReservasInstance, field: "estado")}</g:link></td>
					
						<td><g:formatDate date="${PF_ReservasInstance.fechaLlegada}" /></td>
					
						<td><g:formatDate date="${PF_ReservasInstance.fechaSalida}" /></td>
					
						<td>${fieldValue(bean: PF_ReservasInstance, field: "inmueble")}</td>
					
						<td>${fieldValue(bean: PF_ReservasInstance, field: "numeroHuspedes")}</td>
					
						<td>${fieldValue(bean: PF_ReservasInstance, field: "usuario")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${PF_ReservasInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
