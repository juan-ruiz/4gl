package pf4gl

class PF_Inmuebles {
    String titulo
    String descripcion
    String direccion
    String tipoHabitacion
    String tipoInmueble
    int capacidad
    PF_Usuarios usuario
    Double calificacion
    PF_Ciudades ciudad
    static hasMany = [servicios: PF_Servicios]
    static belongsTo = PF_Servicios
    static mapping = {
        table 'PF_INMUEBLES'
        version false
        id column: 'idInmueble'
        usuario column: 'usuarioscedula'
        ciudad column: 'ciudadesidciudad'
        servicios column: 'servicioidservicio', joinTable: 'PF_SERVICIO_INMUEBLES'
    }
    
    
    String toString(){
        
        "${titulo}"
    }
    
    
}
