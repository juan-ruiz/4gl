<%@ page import="pf4gl.PF_Mensajes" %>



<div class="fieldcontain ${hasErrors(bean: PF_MensajesInstance, field: 'destinatario', 'error')} required">
	<label for="destinatario">
		<g:message code="PF_Mensajes.destinatario.label" default="Destinatario" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="destinatario" name="destinatario.id" from="${pf4gl.PF_Usuarios.list()}" optionKey="id" required="" value="${PF_MensajesInstance?.destinatario?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_MensajesInstance, field: 'mensaje', 'error')} ">
	<label for="mensaje">
		<g:message code="PF_Mensajes.mensaje.label" default="Mensaje" />
		
	</label>
	<g:textField name="mensaje" value="${PF_MensajesInstance?.mensaje}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_MensajesInstance, field: 'remitente', 'error')} required">
	<label for="remitente">
		<g:message code="PF_Mensajes.remitente.label" default="Remitente" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="remitente" name="remitente.id" from="${pf4gl.PF_Usuarios.list()}" optionKey="id" required="" value="${PF_MensajesInstance?.remitente?.id}" class="many-to-one"/>
</div>

