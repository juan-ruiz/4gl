
<%@ page import="pf4gl.PF_Multimedia" %>
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
		<g:set var="entityName" value="${message(code: 'PF_Multimedia.label', default: 'PF_Multimedia')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-PF_Multimedia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-PF_Multimedia" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="PF_Multimedia.inmueble.label" default="Inmueble" /></th>
					
						<g:sortableColumn property="tipo" title="${message(code: 'PF_Multimedia.tipo.label', default: 'Tipo')}" />
					
						<g:sortableColumn property="url" title="${message(code: 'PF_Multimedia.url.label', default: 'Url')}" />
					
						<th><g:message code="PF_Multimedia.usuario.label" default="Usuario" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${PF_MultimediaInstanceList}" status="i" var="PF_MultimediaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${PF_MultimediaInstance.id}">${fieldValue(bean: PF_MultimediaInstance, field: "inmueble")}</g:link></td>
					
						<td>${fieldValue(bean: PF_MultimediaInstance, field: "tipo")}</td>
					
						<td>${fieldValue(bean: PF_MultimediaInstance, field: "url")}</td>
					
						<td>${fieldValue(bean: PF_MultimediaInstance, field: "usuario")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${PF_MultimediaInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
