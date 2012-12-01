
<%@ page import="pf4gl.PF_Ciudades" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'PF_Ciudades.label', default: 'PF_Ciudades')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-PF_Ciudades" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-PF_Ciudades" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="${message(code: 'PF_Ciudades.nombre.label', default: 'Nombre')}" />
					
						<th><g:message code="PF_Ciudades.pais.label" default="Pais" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${PF_CiudadesInstanceList}" status="i" var="PF_CiudadesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${PF_CiudadesInstance.id}">${fieldValue(bean: PF_CiudadesInstance, field: "nombre")}</g:link></td>
					
						<td>${fieldValue(bean: PF_CiudadesInstance, field: "pais")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${PF_CiudadesInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
