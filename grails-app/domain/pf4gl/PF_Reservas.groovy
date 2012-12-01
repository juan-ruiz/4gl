package pf4gl

class PF_Reservas {

    Date fechaSalida
    Date fechaLlegada
    int numeroHuspedes
    PF_Inmuebles inmueble
    PF_Usuarios usuario
    String estado
    
    static mapping = {
        table 'PF_RESERVAS'
        version false
        id column: 'idReserva'
        inmueble column: 'inmueblesidInmueble'
        usuario column: 'usuarioscedula'
    }
}
