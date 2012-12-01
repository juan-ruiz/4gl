package pf4gl
import org.codehaus.groovy.grails.web.context.ServletContextHolder
import org.springframework.dao.DataIntegrityViolationException

class PF_MultimediaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [PF_MultimediaInstanceList: PF_Multimedia.list(params), PF_MultimediaInstanceTotal: PF_Multimedia.count()]
    }

    def create() {
        [PF_MultimediaInstance: new PF_Multimedia(params)]
    
    }

    def save() {
         print "??????????????????????????????????????????????????????????????????????"
        
            
            def imagen = request.getFile('imagen')
            print imagen
            if(!imagen.isEmpty()){
            def servletContext = ServletContextHolder.servletContext
            def storagePath= servletContext.getRealPath("images")
            
            def usuarioId=params.usuario.id
            def inmuebleId=params.inmueble.id
            
            
            
                imagen.transferTo(new File("${storagePath}/inmuebles/${usuarioId}${params.url}${inmuebleId}.jpg"))
                
                print "SISISISISISISISI"
                
            }
        
        
        def PF_MultimediaInstance = new PF_Multimedia(params)
        if (!PF_MultimediaInstance.save(flush: true)) {
        
                            print "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"

            print "NONONOONNOONNONONOON"
            
            
            
            
            
            
            render(view: "create", model: [PF_MultimediaInstance: PF_MultimediaInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'PF_Multimedia.label', default: 'PF_Multimedia'), PF_MultimediaInstance.id])
        redirect(action: "show", id: PF_MultimediaInstance.id)
    }

    def show(Long id) {
        def PF_MultimediaInstance = PF_Multimedia.get(id)
        if (!PF_MultimediaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Multimedia.label', default: 'PF_Multimedia'), id])
            redirect(action: "list")
            return
        }

        [PF_MultimediaInstance: PF_MultimediaInstance]
    }

    def edit(Long id) {
        def PF_MultimediaInstance = PF_Multimedia.get(id)
        if (!PF_MultimediaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Multimedia.label', default: 'PF_Multimedia'), id])
            redirect(action: "list")
            return
        }

        [PF_MultimediaInstance: PF_MultimediaInstance]
    }

    def update(Long id, Long version) {
        def PF_MultimediaInstance = PF_Multimedia.get(id)
        if (!PF_MultimediaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Multimedia.label', default: 'PF_Multimedia'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (PF_MultimediaInstance.version > version) {
                PF_MultimediaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'PF_Multimedia.label', default: 'PF_Multimedia')] as Object[],
                          "Another user has updated this PF_Multimedia while you were editing")
                render(view: "edit", model: [PF_MultimediaInstance: PF_MultimediaInstance])
                return
            }
        }

        PF_MultimediaInstance.properties = params

        if (!PF_MultimediaInstance.save(flush: true)) {
            render(view: "edit", model: [PF_MultimediaInstance: PF_MultimediaInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'PF_Multimedia.label', default: 'PF_Multimedia'), PF_MultimediaInstance.id])
        redirect(action: "show", id: PF_MultimediaInstance.id)
    }

    def delete(Long id) {
        def PF_MultimediaInstance = PF_Multimedia.get(id)
        if (!PF_MultimediaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Multimedia.label', default: 'PF_Multimedia'), id])
            redirect(action: "list")
            return
        }

        try {
            PF_MultimediaInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'PF_Multimedia.label', default: 'PF_Multimedia'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'PF_Multimedia.label', default: 'PF_Multimedia'), id])
            redirect(action: "show", id: id)
        }
    }
}
