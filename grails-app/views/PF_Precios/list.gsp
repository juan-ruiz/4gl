
<%@ page import="pf4gl.PF_Precios" %>
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
		<g:set var="entityName" value="${message(code: 'PF_Precios.label', default: 'PF_Precios')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-PF_Precios" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-PF_Precios" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="fechafin" title="${message(code: 'PF_Precios.fechafin.label', default: 'Fechafin')}" />
					
						<g:sortableColumn property="fechainicio" title="${message(code: 'PF_Precios.fechainicio.label', default: 'Fechainicio')}" />
					
						<th><g:message code="PF_Precios.inmueble.label" default="Inmueble" /></th>
					
						<g:sortableColumn property="montoPrecio" title="${message(code: 'PF_Precios.montoPrecio.label', default: 'Monto Precio')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${PF_PreciosInstanceList}" status="i" var="PF_PreciosInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${PF_PreciosInstance.id}">${fieldValue(bean: PF_PreciosInstance, field: "fechafin")}</g:link></td>
					
						<td><g:formatDate date="${PF_PreciosInstance.fechainicio}" /></td>
					
						<td>${fieldValue(bean: PF_PreciosInstance, field: "inmueble")}</td>
					
						<td>${fieldValue(bean: PF_PreciosInstance, field: "montoPrecio")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${PF_PreciosInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
