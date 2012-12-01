package pf4gl

class RegistroTagLib {
  def registroControl = {
    if(!session.user){
      out << """${link(action:"registro", controller:"PF_Usuarios"){"Registro"}}"""      
   }
  }
}
