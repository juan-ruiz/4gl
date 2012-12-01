package pf4gl

class PF_Recomendaciones {
    private String descripcion
    PF_Inmuebles inmueble
    PF_Usuarios usuario
    PF_Reservas reserva
    static mapping = {
        table 'PF_RECOMENDACIONES'
        version false
        id column: 'idRecomendacion'
        inmueble column: 'inmueblesidInmueble'
        usuario column: 'usuarioscedula'
        reserva column: 'reservaidReserva'
    }
}
