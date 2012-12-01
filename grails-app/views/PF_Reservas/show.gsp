
<%@ page import="pf4gl.PF_Reservas" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'PF_Reservas.label', default: 'PF_Reservas')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-PF_Reservas" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-PF_Reservas" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list PF_Reservas">
			
				<g:if test="${PF_ReservasInstance?.estado}">
				<li class="fieldcontain">
					<span id="estado-label" class="property-label"><g:message code="PF_Reservas.estado.label" default="Estado" /></span>
					
						<span class="property-value" aria-labelledby="estado-label"><g:fieldValue bean="${PF_ReservasInstance}" field="estado"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_ReservasInstance?.fechaLlegada}">
				<li class="fieldcontain">
					<span id="fechaLlegada-label" class="property-label"><g:message code="PF_Reservas.fechaLlegada.label" default="Fecha Llegada" /></span>
					
						<span class="property-value" aria-labelledby="fechaLlegada-label"><g:formatDate date="${PF_ReservasInstance?.fechaLlegada}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_ReservasInstance?.fechaSalida}">
				<li class="fieldcontain">
					<span id="fechaSalida-label" class="property-label"><g:message code="PF_Reservas.fechaSalida.label" default="Fecha Salida" /></span>
					
						<span class="property-value" aria-labelledby="fechaSalida-label"><g:formatDate date="${PF_ReservasInstance?.fechaSalida}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_ReservasInstance?.inmueble}">
				<li class="fieldcontain">
					<span id="inmueble-label" class="property-label"><g:message code="PF_Reservas.inmueble.label" default="Inmueble" /></span>
					
						<span class="property-value" aria-labelledby="inmueble-label"><g:link controller="PF_Inmuebles" action="show" id="${PF_ReservasInstance?.inmueble?.id}">${PF_ReservasInstance?.inmueble?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_ReservasInstance?.numeroHuspedes}">
				<li class="fieldcontain">
					<span id="numeroHuspedes-label" class="property-label"><g:message code="PF_Reservas.numeroHuspedes.label" default="Numero Huspedes" /></span>
					
						<span class="property-value" aria-labelledby="numeroHuspedes-label"><g:fieldValue bean="${PF_ReservasInstance}" field="numeroHuspedes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_ReservasInstance?.usuario}">
				<li class="fieldcontain">
					<span id="usuario-label" class="property-label"><g:message code="PF_Reservas.usuario.label" default="Usuario" /></span>
					
						<span class="property-value" aria-labelledby="usuario-label"><g:link controller="PF_Usuarios" action="show" id="${PF_ReservasInstance?.usuario?.id}">${PF_ReservasInstance?.usuario?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${PF_ReservasInstance?.id}" />
					<g:link class="edit" action="edit" id="${PF_ReservasInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
