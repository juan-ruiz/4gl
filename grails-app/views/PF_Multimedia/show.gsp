
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
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-PF_Multimedia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-PF_Multimedia" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list PF_Multimedia">
			
				<g:if test="${PF_MultimediaInstance?.inmueble}">
				<li class="fieldcontain">
					<span id="inmueble-label" class="property-label"><g:message code="PF_Multimedia.inmueble.label" default="Inmueble" /></span>
					
						<span class="property-value" aria-labelledby="inmueble-label"><g:link controller="PF_Inmuebles" action="show" id="${PF_MultimediaInstance?.inmueble?.id}">${PF_MultimediaInstance?.inmueble?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_MultimediaInstance?.tipo}">
				<li class="fieldcontain">
					<span id="tipo-label" class="property-label"><g:message code="PF_Multimedia.tipo.label" default="Tipo" /></span>
					
						<span class="property-value" aria-labelledby="tipo-label"><g:fieldValue bean="${PF_MultimediaInstance}" field="tipo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_MultimediaInstance?.url}">
				<li class="fieldcontain">
					<span id="url-label" class="property-label"><g:message code="PF_Multimedia.url.label" default="Url" /></span>
					
						<span class="property-value" aria-labelledby="url-label"><g:fieldValue bean="${PF_MultimediaInstance}" field="url"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${PF_MultimediaInstance?.usuario}">
				<li class="fieldcontain">
					<span id="usuario-label" class="property-label"><g:message code="PF_Multimedia.usuario.label" default="Usuario" /></span>
					
						<span class="property-value" aria-labelledby="usuario-label"><g:link controller="PF_Usuarios" action="show" id="${PF_MultimediaInstance?.usuario?.id}">${PF_MultimediaInstance?.usuario?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${PF_MultimediaInstance?.id}" />
					<g:link class="edit" action="edit" id="${PF_MultimediaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
