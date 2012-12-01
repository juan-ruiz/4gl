<%@ page import="pf4gl.PF_Reservas" %>



<div class="fieldcontain ${hasErrors(bean: PF_ReservasInstance, field: 'estado', 'error')} ">
	<label for="estado">
		<g:message code="PF_Reservas.estado.label" default="Estado" />
		
	</label>
	<g:textField name="estado" value="${PF_ReservasInstance?.estado}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_ReservasInstance, field: 'fechaLlegada', 'error')} required">
	<label for="fechaLlegada">
		<g:message code="PF_Reservas.fechaLlegada.label" default="Fecha Llegada" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaLlegada" precision="day"  value="${PF_ReservasInstance?.fechaLlegada}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: PF_ReservasInstance, field: 'fechaSalida', 'error')} required">
	<label for="fechaSalida">
		<g:message code="PF_Reservas.fechaSalida.label" default="Fecha Salida" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaSalida" precision="day"  value="${PF_ReservasInstance?.fechaSalida}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: PF_ReservasInstance, field: 'inmueble', 'error')} required">
	<label for="inmueble">
		<g:message code="PF_Reservas.inmueble.label" default="Inmueble" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="inmueble" name="inmueble.id" from="${pf4gl.PF_Inmuebles.list()}" optionKey="id" required="" value="${PF_ReservasInstance?.inmueble?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_ReservasInstance, field: 'numeroHuspedes', 'error')} required">
	<label for="numeroHuspedes">
		<g:message code="PF_Reservas.numeroHuspedes.label" default="Numero Huspedes" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="numeroHuspedes" type="number" value="${PF_ReservasInstance.numeroHuspedes}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_ReservasInstance, field: 'usuario', 'error')} required">
	<label for="usuario">
		<g:message code="PF_Reservas.usuario.label" default="Usuario" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="usuario" name="usuario.id" from="${pf4gl.PF_Usuarios.list()}" optionKey="id" required="" value="${PF_ReservasInstance?.usuario?.id}" class="many-to-one"/>
</div>

