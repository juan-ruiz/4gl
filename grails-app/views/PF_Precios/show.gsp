
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
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-PF_Precios" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-PF_Precios" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list PF_Precios">
			
				<g:if test="${PF_PreciosInstance?.fechafin}">
				<li class="fieldcontain">
					<span id="fechafin-label" class="property-label"><g:message code="PF_Precios.fechafin.label" default="Fechafin" /></span>
					
						<span class="property-value" aria-labelledby="fechafin-label"><g:formatDate date="${PF_PreciosInstance?.fechafin}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_PreciosInstance?.fechainicio}">
				<li class="fieldcontain">
					<span id="fechainicio-label" class="property-label"><g:message code="PF_Precios.fechainicio.label" default="Fechainicio" /></span>
					
						<span class="property-value" aria-labelledby="fechainicio-label"><g:formatDate date="${PF_PreciosInstance?.fechainicio}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_PreciosInstance?.inmueble}">
				<li class="fieldcontain">
					<span id="inmueble-label" class="property-label"><g:message code="PF_Precios.inmueble.label" default="Inmueble" /></span>
					
						<span class="property-value" aria-labelledby="inmueble-label"><g:link controller="PF_Inmuebles" action="show" id="${PF_PreciosInstance?.inmueble?.id}">${PF_PreciosInstance?.inmueble?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_PreciosInstance?.montoPrecio}">
				<li class="fieldcontain">
					<span id="montoPrecio-label" class="property-label"><g:message code="PF_Precios.montoPrecio.label" default="Monto Precio" /></span>
					
						<span class="property-value" aria-labelledby="montoPrecio-label"><g:fieldValue bean="${PF_PreciosInstance}" field="montoPrecio"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${PF_PreciosInstance?.id}" />
					<g:link class="edit" action="edit" id="${PF_PreciosInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
