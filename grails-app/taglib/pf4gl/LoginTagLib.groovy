package pf4gl

class LoginTagLib {
  def loginControl = {
    if(session.user){
      out << "[${session.user.nombre} ${session.user.apellido}]"
      out << """${link(action:"logout", controller:"PF_Usuarios"){"Logout"}}"""
    } else {
      out << """${link(action:"login", controller:"PF_Usuarios"){"Login"}}"""      
    }
  }
}
