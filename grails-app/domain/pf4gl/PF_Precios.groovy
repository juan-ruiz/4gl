package pf4gl

class PF_Precios {
    Date fechainicio
    Date fechafin
    double montoPrecio
    PF_Inmuebles inmueble
    static mapping = {
        table 'PF_PRECIOS'
        version false
        id column: 'idprecio'
        inmueble column: 'inmueblesidInmueble'
    }
}
