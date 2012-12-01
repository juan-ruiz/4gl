
<%@ page import="pf4gl.PF_Pagos" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'PF_Pagos.label', default: 'PF_Pagos')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-PF_Pagos" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-PF_Pagos" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="fecha" title="${message(code: 'PF_Pagos.fecha.label', default: 'Fecha')}" />
					
						<g:sortableColumn property="montodepago" title="${message(code: 'PF_Pagos.montodepago.label', default: 'Montodepago')}" />
					
						<th><g:message code="PF_Pagos.reserva.label" default="Reserva" /></th>
					
						<g:sortableColumn property="tipo" title="${message(code: 'PF_Pagos.tipo.label', default: 'Tipo')}" />
					
						<g:sortableColumn property="valorpactado" title="${message(code: 'PF_Pagos.valorpactado.label', default: 'Valorpactado')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${PF_PagosInstanceList}" status="i" var="PF_PagosInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${PF_PagosInstance.id}">${fieldValue(bean: PF_PagosInstance, field: "fecha")}</g:link></td>
					
						<td>${fieldValue(bean: PF_PagosInstance, field: "montodepago")}</td>
					
						<td>${fieldValue(bean: PF_PagosInstance, field: "reserva")}</td>
					
						<td>${fieldValue(bean: PF_PagosInstance, field: "tipo")}</td>
					
						<td>${fieldValue(bean: PF_PagosInstance, field: "valorpactado")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${PF_PagosInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
