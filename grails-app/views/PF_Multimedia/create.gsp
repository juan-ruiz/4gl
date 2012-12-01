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
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-PF_Multimedia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-PF_Multimedia" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${PF_MultimediaInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${PF_MultimediaInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="save" method ="post" enctype="multipart/form-data">
				<fieldset class="form">
					
                                  
                             <div class="fieldcontain ${hasErrors(bean: PF_MultimediaInstance, field: 'inmueble', 'error')} required">
	<label for="inmueble">
		<g:message code="PF_Multimedia.inmueble.label" default="Inmueble" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="inmueble" name="inmueble.id" from="${pf4gl.PF_Inmuebles.list()}" optionKey="id" required="" value="${PF_MultimediaInstance?.inmueble?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_MultimediaInstance, field: 'tipo', 'error')} ">
	<label for="tipo">
		<g:message code="PF_Multimedia.tipo.label" default="Tipo" />
		
	</label>
	<g:textField name="tipo" value="${PF_MultimediaInstance?.tipo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_MultimediaInstance, field: 'url', 'error')} ">
	<label for="url">
		<g:message code="PF_Multimedia.url.label" default="Nombre" />
		
	</label>
	<g:textField name="url" value="${PF_MultimediaInstance?.url}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_MultimediaInstance, field: 'usuario', 'error')} required">
	<label for="usuario">
		<g:message code="PF_Multimedia.usuario.label" default="Usuario" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="usuario" name="usuario.id" from="${pf4gl.PF_Usuarios.list()}" optionKey="id" required="" value="${PF_MultimediaInstance?.usuario?.id}" class="many-to-one"/>
</div>
     
                                  
                                  
                                  
    <div style="position:relative;top: 15px;
left: 165px;">
	<label >
		Archivo
		
	</label>
	<input type="file" name="imagen"/>
</div>
                                  
                                  
                                  
                                  
				</fieldset>
                          
                          
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
