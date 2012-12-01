package pf4gl

class PF_Mensajes {
    String mensaje
    PF_Usuarios remitente
    PF_Usuarios destinatario
    static mapping = {
        table 'PF_MENSAJES'
        version false
        id column: 'idmensaje'
        remitente column: 'usuariosremitente'
        destinatario column: 'usuariosdestinatario'
    }
}
