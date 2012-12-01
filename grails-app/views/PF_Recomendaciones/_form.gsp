<%@ page import="pf4gl.PF_Recomendaciones" %>



<div class="fieldcontain ${hasErrors(bean: PF_RecomendacionesInstance, field: 'inmueble', 'error')} required">
	<label for="inmueble">
		<g:message code="PF_Recomendaciones.inmueble.label" default="Inmueble" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="inmueble" name="inmueble.id" from="${pf4gl.PF_Inmuebles.list()}" optionKey="id" required="" value="${PF_RecomendacionesInstance?.inmueble?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_RecomendacionesInstance, field: 'reserva', 'error')} required">
	<label for="reserva">
		<g:message code="PF_Recomendaciones.reserva.label" default="Reserva" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="reserva" name="reserva.id" from="${pf4gl.PF_Reservas.list()}" optionKey="id" required="" value="${PF_RecomendacionesInstance?.reserva?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_RecomendacionesInstance, field: 'usuario', 'error')} required">
	<label for="usuario">
		<g:message code="PF_Recomendaciones.usuario.label" default="Usuario" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="usuario" name="usuario.id" from="${pf4gl.PF_Usuarios.list()}" optionKey="id" required="" value="${PF_RecomendacionesInstance?.usuario?.id}" class="many-to-one"/>
</div>

