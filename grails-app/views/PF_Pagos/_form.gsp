<%@ page import="pf4gl.PF_Pagos" %>



<div class="fieldcontain ${hasErrors(bean: PF_PagosInstance, field: 'fecha', 'error')} required">
	<label for="fecha">
		<g:message code="PF_Pagos.fecha.label" default="Fecha" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fecha" precision="day"  value="${PF_PagosInstance?.fecha}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: PF_PagosInstance, field: 'montodepago', 'error')} required">
	<label for="montodepago">
		<g:message code="PF_Pagos.montodepago.label" default="Montodepago" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="montodepago" value="${fieldValue(bean: PF_PagosInstance, field: 'montodepago')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_PagosInstance, field: 'reserva', 'error')} required">
	<label for="reserva">
		<g:message code="PF_Pagos.reserva.label" default="Reserva" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="reserva" name="reserva.id" from="${pf4gl.PF_Reservas.list()}" optionKey="id" required="" value="${PF_PagosInstance?.reserva?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_PagosInstance, field: 'tipo', 'error')} ">
	<label for="tipo">
		<g:message code="PF_Pagos.tipo.label" default="Tipo" />
		
	</label>
	<g:textField name="tipo" value="${PF_PagosInstance?.tipo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_PagosInstance, field: 'valorpactado', 'error')} required">
	<label for="valorpactado">
		<g:message code="PF_Pagos.valorpactado.label" default="Valorpactado" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="valorpactado" value="${fieldValue(bean: PF_PagosInstance, field: 'valorpactado')}" required=""/>
</div>

