
<%@ page import="pf4gl.PF_Mensajes" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'PF_Mensajes.label', default: 'PF_Mensajes')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-PF_Mensajes" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-PF_Mensajes" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list PF_Mensajes">
			
				<g:if test="${PF_MensajesInstance?.destinatario}">
				<li class="fieldcontain">
					<span id="destinatario-label" class="property-label"><g:message code="PF_Mensajes.destinatario.label" default="Destinatario" /></span>
					
						<span class="property-value" aria-labelledby="destinatario-label"><g:link controller="PF_Usuarios" action="show" id="${PF_MensajesInstance?.destinatario?.id}">${PF_MensajesInstance?.destinatario?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_MensajesInstance?.mensaje}">
				<li class="fieldcontain">
					<span id="mensaje-label" class="property-label"><g:message code="PF_Mensajes.mensaje.label" default="Mensaje" /></span>
					
						<span class="property-value" aria-labelledby="mensaje-label"><g:fieldValue bean="${PF_MensajesInstance}" field="mensaje"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_MensajesInstance?.remitente}">
				<li class="fieldcontain">
					<span id="remitente-label" class="property-label"><g:message code="PF_Mensajes.remitente.label" default="Remitente" /></span>
					
						<span class="property-value" aria-labelledby="remitente-label"><g:link controller="PF_Usuarios" action="show" id="${PF_MensajesInstance?.remitente?.id}">${PF_MensajesInstance?.remitente?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${PF_MensajesInstance?.id}" />
					<g:link class="edit" action="edit" id="${PF_MensajesInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
