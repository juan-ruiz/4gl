package pf4gl

import org.springframework.dao.DataIntegrityViolationException

class PF_UsuariosController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [PF_UsuariosInstanceList: PF_Usuarios.list(params), PF_UsuariosInstanceTotal: PF_Usuarios.count()]
    }

    def create() {
        [PF_UsuariosInstance: new PF_Usuarios(params)]
    }

    def save() {
        def PF_UsuariosInstance = new PF_Usuarios(params)
        
        PF_UsuariosInstance.id = params.id.toLong()
        if (!PF_UsuariosInstance.save(flush: true)) {
            render(view: "create", model: [PF_UsuariosInstance: PF_UsuariosInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'PF_Usuarios.label', default: 'PF_Usuarios'), PF_UsuariosInstance.id])
        redirect(url: "/")
    }

    def show(Long id) {
        def PF_UsuariosInstance = PF_Usuarios.get(id)
        if (!PF_UsuariosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Usuarios.label', default: 'PF_Usuarios'), id])
            redirect(action: "list")
            return
        }

        [PF_UsuariosInstance: PF_UsuariosInstance]
    }

    def edit(Long id) {
        def PF_UsuariosInstance = PF_Usuarios.get(id)
        if (!PF_UsuariosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Usuarios.label', default: 'PF_Usuarios'), id])
            redirect(action: "list")
            return
        }

        [PF_UsuariosInstance: PF_UsuariosInstance]
    }

    def update(Long id, Long version) {
        def PF_UsuariosInstance = PF_Usuarios.get(id)
        if (!PF_UsuariosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Usuarios.label', default: 'PF_Usuarios'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (PF_UsuariosInstance.version > version) {
                PF_UsuariosInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'PF_Usuarios.label', default: 'PF_Usuarios')] as Object[],
                          "Another user has updated this PF_Usuarios while you were editing")
                render(view: "edit", model: [PF_UsuariosInstance: PF_UsuariosInstance])
                return
            }
        }

        PF_UsuariosInstance.properties = params

        if (!PF_UsuariosInstance.save(flush: true)) {
            render(view: "edit", model: [PF_UsuariosInstance: PF_UsuariosInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'PF_Usuarios.label', default: 'PF_Usuarios'), PF_UsuariosInstance.id])
        redirect(action: "show", id: PF_UsuariosInstance.id)
    }

    def delete(Long id) {
        def PF_UsuariosInstance = PF_Usuarios.get(id)
        if (!PF_UsuariosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Usuarios.label', default: 'PF_Usuarios'), id])
            redirect(action: "list")
            return
        }

        try {
            PF_UsuariosInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'PF_Usuarios.label', default: 'PF_Usuarios'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'PF_Usuarios.label', default: 'PF_Usuarios'), id])
            redirect(action: "show", id: id)
        }
    }
    
    
    def login = {}
  
    def authenticate = {
      def user = PF_Usuarios.findByNickAndPassword(params.login, params.password)
      if(user){
        session.user = user
        flash.message = "Hola ${user.nombre}!"
        redirect(url:"/")      
      }else{
        flash.message = "Lo siento, ${params.login}. Por favor inténtalo de nuevo."
       redirect(controller:"PF_Usuarios", action:"login")  
      }
    }
  
    def logout = {
      flash.message = "Hasta luego ${session.user.nombre}"
      session.user = null
      redirect(controller:"PF_Usuarios", action:"login")      
    }  
}
