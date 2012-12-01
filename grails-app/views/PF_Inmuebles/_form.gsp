<%@ page import="pf4gl.PF_Inmuebles" %>



<div class="fieldcontain ${hasErrors(bean: PF_InmueblesInstance, field: 'calificacion', 'error')} required">
	<label for="calificacion">
		<g:message code="PF_Inmuebles.calificacion.label" default="Calificacion" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="calificacion" value="${fieldValue(bean: PF_InmueblesInstance, field: 'calificacion')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_InmueblesInstance, field: 'capacidad', 'error')} required">
	<label for="capacidad">
		<g:message code="PF_Inmuebles.capacidad.label" default="Capacidad" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="capacidad" type="number" value="${PF_InmueblesInstance.capacidad}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_InmueblesInstance, field: 'ciudad', 'error')} required">
	<label for="ciudad">
		<g:message code="PF_Inmuebles.ciudad.label" default="Ciudad" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="ciudad" name="ciudad.id" from="${pf4gl.PF_Ciudades.list()}" optionKey="id" required="" value="${PF_InmueblesInstance?.ciudad?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_InmueblesInstance, field: 'descripcion', 'error')} ">
	<label for="descripcion">
		<g:message code="PF_Inmuebles.descripcion.label" default="Descripcion" />
		
	</label>
	<g:textField name="descripcion" value="${PF_InmueblesInstance?.descripcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_InmueblesInstance, field: 'direccion', 'error')} ">
	<label for="direccion">
		<g:message code="PF_Inmuebles.direccion.label" default="Direccion" />
		
	</label>
	<g:textField name="direccion" value="${PF_InmueblesInstance?.direccion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_InmueblesInstance, field: 'servicios', 'error')} ">
	<label for="servicios">
		<g:message code="PF_Inmuebles.servicios.label" default="Servicios" />
		
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: PF_InmueblesInstance, field: 'tipoHabitacion', 'error')} ">
	<label for="tipoHabitacion">
		<g:message code="PF_Inmuebles.tipoHabitacion.label" default="Tipo Habitacion" />
		
	</label>
	<g:textField name="tipoHabitacion" value="${PF_InmueblesInstance?.tipoHabitacion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_InmueblesInstance, field: 'tipoInmueble', 'error')} ">
	<label for="tipoInmueble">
		<g:message code="PF_Inmuebles.tipoInmueble.label" default="Tipo Inmueble" />
		
	</label>
	<g:textField name="tipoInmueble" value="${PF_InmueblesInstance?.tipoInmueble}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_InmueblesInstance, field: 'titulo', 'error')} ">
	<label for="titulo">
		<g:message code="PF_Inmuebles.titulo.label" default="Titulo" />
		
	</label>
	<g:textField name="titulo" value="${PF_InmueblesInstance?.titulo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: PF_InmueblesInstance, field: 'usuario', 'error')} required">
	<label for="usuario">
		<g:message code="PF_Inmuebles.usuario.label" default="Usuario" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="usuario" name="usuario.id" from="${pf4gl.PF_Usuarios.list()}" optionKey="id" required="" value="${PF_InmueblesInstance?.usuario?.id}" class="many-to-one"/>
</div>

