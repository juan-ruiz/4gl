package pf4gl

class PF_Usuarios implements java.io.Serializable {
    String nombre
    String correo
    String celular
    String telefono
    String apellido
    String password
    String nick
    Long id
    static hasMany = [roles: PF_Roles]
    static belongsTo = PF_Roles
    static mapping = {
        table 'PF_USUARIOS'
        version false
        id  generator: 'assigned'
        roles column: 'rolesid_rol', joinTable: 'PF_ROLES_USUARIOS'
    }
    
    
     String toString(){
        
        "${nick}"
    }
    
    
    
    

}