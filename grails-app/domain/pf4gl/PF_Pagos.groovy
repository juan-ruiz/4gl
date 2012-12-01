package pf4gl

class PF_Pagos {
    Date fecha
    String tipo
    double montodepago
    double valorpactado
    PF_Reservas reserva
    static mapping = {
        table 'PF_PAGOS'
        version false
        id column: 'idPago'
        reserva column: 'reservaidReserva'
    }
}
