<%@ page import="pf4gl.PF_Multimedia" %>



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

