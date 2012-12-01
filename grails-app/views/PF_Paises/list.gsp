
<%@ page import="pf4gl.PF_Paises" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'PF_Paises.label', default: 'PF_Paises')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-PF_Paises" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-PF_Paises" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nomre" title="${message(code: 'PF_Paises.nomre.label', default: 'Nomre')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${PF_PaisesInstanceList}" status="i" var="PF_PaisesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${PF_PaisesInstance.id}">${fieldValue(bean: PF_PaisesInstance, field: "nomre")}</g:link></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${PF_PaisesInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
