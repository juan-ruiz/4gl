
<%@ page import="pf4gl.PF_Pagos" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'PF_Pagos.label', default: 'PF_Pagos')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-PF_Pagos" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-PF_Pagos" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list PF_Pagos">
			
				<g:if test="${PF_PagosInstance?.fecha}">
				<li class="fieldcontain">
					<span id="fecha-label" class="property-label"><g:message code="PF_Pagos.fecha.label" default="Fecha" /></span>
					
						<span class="property-value" aria-labelledby="fecha-label"><g:formatDate date="${PF_PagosInstance?.fecha}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_PagosInstance?.montodepago}">
				<li class="fieldcontain">
					<span id="montodepago-label" class="property-label"><g:message code="PF_Pagos.montodepago.label" default="Montodepago" /></span>
					
						<span class="property-value" aria-labelledby="montodepago-label"><g:fieldValue bean="${PF_PagosInstance}" field="montodepago"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_PagosInstance?.reserva}">
				<li class="fieldcontain">
					<span id="reserva-label" class="property-label"><g:message code="PF_Pagos.reserva.label" default="Reserva" /></span>
					
						<span class="property-value" aria-labelledby="reserva-label"><g:link controller="PF_Reservas" action="show" id="${PF_PagosInstance?.reserva?.id}">${PF_PagosInstance?.reserva?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_PagosInstance?.tipo}">
				<li class="fieldcontain">
					<span id="tipo-label" class="property-label"><g:message code="PF_Pagos.tipo.label" default="Tipo" /></span>
					
						<span class="property-value" aria-labelledby="tipo-label"><g:fieldValue bean="${PF_PagosInstance}" field="tipo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_PagosInstance?.valorpactado}">
				<li class="fieldcontain">
					<span id="valorpactado-label" class="property-label"><g:message code="PF_Pagos.valorpactado.label" default="Valorpactado" /></span>
					
						<span class="property-value" aria-labelledby="valorpactado-label"><g:fieldValue bean="${PF_PagosInstance}" field="valorpactado"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${PF_PagosInstance?.id}" />
					<g:link class="edit" action="edit" id="${PF_PagosInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
