package pf4gl

class PF_Servicios {
    String descripcion
    static hasMany = [inmuebles: PF_Inmuebles]
    static mapping = {
        table 'PF_SERVICIOS'
        version false
        id column: 'idservicio'
        inmuebles column: 'inmueblesid_inmueble', joinTable: 'PF_SERVICIO_INMUEBLES'
    }
}