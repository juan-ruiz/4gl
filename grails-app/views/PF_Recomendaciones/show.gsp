
<%@ page import="pf4gl.PF_Recomendaciones" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'PF_Recomendaciones.label', default: 'PF_Recomendaciones')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-PF_Recomendaciones" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-PF_Recomendaciones" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list PF_Recomendaciones">
			
				<g:if test="${PF_RecomendacionesInstance?.inmueble}">
				<li class="fieldcontain">
					<span id="inmueble-label" class="property-label"><g:message code="PF_Recomendaciones.inmueble.label" default="Inmueble" /></span>
					
						<span class="property-value" aria-labelledby="inmueble-label"><g:link controller="PF_Inmuebles" action="show" id="${PF_RecomendacionesInstance?.inmueble?.id}">${PF_RecomendacionesInstance?.inmueble?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_RecomendacionesInstance?.reserva}">
				<li class="fieldcontain">
					<span id="reserva-label" class="property-label"><g:message code="PF_Recomendaciones.reserva.label" default="Reserva" /></span>
					
						<span class="property-value" aria-labelledby="reserva-label"><g:link controller="PF_Reservas" action="show" id="${PF_RecomendacionesInstance?.reserva?.id}">${PF_RecomendacionesInstance?.reserva?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_RecomendacionesInstance?.usuario}">
				<li class="fieldcontain">
					<span id="usuario-label" class="property-label"><g:message code="PF_Recomendaciones.usuario.label" default="Usuario" /></span>
					
						<span class="property-value" aria-labelledby="usuario-label"><g:link controller="PF_Usuarios" action="show" id="${PF_RecomendacionesInstance?.usuario?.id}">${PF_RecomendacionesInstance?.usuario?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${PF_RecomendacionesInstance?.id}" />
					<g:link class="edit" action="edit" id="${PF_RecomendacionesInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
