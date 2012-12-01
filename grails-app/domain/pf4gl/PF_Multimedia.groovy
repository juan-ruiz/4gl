package pf4gl

class PF_Multimedia {
    String tipo
    String url
    PF_Inmuebles inmueble
    PF_Usuarios usuario
    static mapping = {
        table 'PF_MULTIMEDIA'
        version false
        id column: 'idMultimedia'
        inmueble column: 'inmueblesidInmueble'
        usuario column: 'usuarioscedula'
    }
}
