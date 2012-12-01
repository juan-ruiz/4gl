
<%@ page import="pf4gl.PF_Inmuebles" %>
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
		<g:set var="entityName" value="${message(code: 'PF_Inmuebles.label', default: 'PF_Inmuebles')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-PF_Inmuebles" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-PF_Inmuebles" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="calificacion" title="${message(code: 'PF_Inmuebles.calificacion.label', default: 'Calificacion')}" />
					
						<g:sortableColumn property="capacidad" title="${message(code: 'PF_Inmuebles.capacidad.label', default: 'Capacidad')}" />
					
						<th><g:message code="PF_Inmuebles.ciudad.label" default="Ciudad" /></th>
					
						<g:sortableColumn property="descripcion" title="${message(code: 'PF_Inmuebles.descripcion.label', default: 'Descripcion')}" />
					
						<g:sortableColumn property="direccion" title="${message(code: 'PF_Inmuebles.direccion.label', default: 'Direccion')}" />
					
						<g:sortableColumn property="tipoHabitacion" title="${message(code: 'PF_Inmuebles.tipoHabitacion.label', default: 'Tipo Habitacion')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${PF_InmueblesInstanceList}" status="i" var="PF_InmueblesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${PF_InmueblesInstance.id}">${fieldValue(bean: PF_InmueblesInstance, field: "calificacion")}</g:link></td>
					
						<td>${fieldValue(bean: PF_InmueblesInstance, field: "capacidad")}</td>
					
						<td>${fieldValue(bean: PF_InmueblesInstance, field: "ciudad")}</td>
					
						<td>${fieldValue(bean: PF_InmueblesInstance, field: "descripcion")}</td>
					
						<td>${fieldValue(bean: PF_InmueblesInstance, field: "direccion")}</td>
					
						<td>${fieldValue(bean: PF_InmueblesInstance, field: "tipoHabitacion")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${PF_InmueblesInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
