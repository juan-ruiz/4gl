package pf4gl

class PF_Roles {
    String nombre
    static hasMany = [usuarios: PF_Usuarios] 
    static mapping = {
        table 'PF_ROLES'
        version false
        id column: 'idrol'
        usuarios column: 'usuarioscedula', joinTable: 'PF_ROLES_USUARIOS'
    }
}
