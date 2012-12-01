<%@ page import="pf4gl.PF_Precios" %>


<div class="fieldcontain ${hasErrors(bean: PF_PreciosInstance, field: 'fechainicio', 'error')} required">
	<label for="fechainicio">
		<g:message code="PF_Precios.fechainicio.label" default="Fecha Inicio" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechainicio" precision="day"  value="${PF_PreciosInstance?.fechainicio}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: PF_PreciosInstance, field: 'fechafin', 'error')} required">
	<label for="fechafin">
		<g:message code="PF_Precios.fechafin.label" default="Fecha Final" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechafin" precision="day"  value="${PF_PreciosInstance?.fechafin}"  />
</div>



<div class="fieldcontain ${hasErrors(bean: PF_PreciosInstance, field: 'inmueble', 'error')} required">
	<label for="inmueble">
		<g:message code="PF_Precios.inmueble.label" default="Inmueble" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="inmueble" name="inmueble.id" from="${pf4gl.PF_Inmuebles.list()}" optionKey="id" required="" value="${PF_PreciosInstance?.inmueble?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_PreciosInstance, field: 'montoPrecio', 'error')} required">
	<label for="montoPrecio">
		<g:message code="PF_Precios.montoPrecio.label" default="Monto Precio" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="montoPrecio" value="${fieldValue(bean: PF_PreciosInstance, field: 'montoPrecio')}" required=""/>
</div>

