package pf4gl
 
import org.springframework.dao.DataIntegrityViolationException

class PF_InmueblesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [PF_InmueblesInstanceList: PF_Inmuebles.list(params), PF_InmueblesInstanceTotal: PF_Inmuebles.count()]
    }
    def listb() {
        String cadena = params.consulta
        print cadena
        
        
        
        
       def PF_InmueblesInstanceList  =PF_Inmuebles.findAllByDescripcionLike("%${cadena}%", [max: 10, sort: "id", order: "asc"])
       
        def inmueblefoto = [:]
       print PF_InmueblesInstanceList
        for(inmueble in PF_InmueblesInstanceList){
            
            def fotolist   = PF_Multimedia.findAllByInmueble(inmueble,[sort: "url", order: "asc"])
            inmueblefoto[(inmueble)]=fotolist [0]
            print "funcasapaperra"
            print inmueble
            print fotolist [0]
            
        }
        
        
        
        
        [inmueblefoto:inmueblefoto]
    }

    def create() {
        [PF_InmueblesInstance: new PF_Inmuebles(params)]
    }

    def save() {
        def PF_InmueblesInstance = new PF_Inmuebles(params)
        if (!PF_InmueblesInstance.save(flush: true)) {
            render(view: "create", model: [PF_InmueblesInstance: PF_InmueblesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'PF_Inmuebles.label', default: 'PF_Inmuebles'), PF_InmueblesInstance.id])
        redirect(action: "show", id: PF_InmueblesInstance.id)
    }

    def show(Long id) {
        def PF_InmueblesInstance = PF_Inmuebles.get(id)
        if (!PF_InmueblesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Inmuebles.label', default: 'PF_Inmuebles'), id])
            redirect(action: "list")
            return
        }
        def PF_PreciosList = PF_Precios.findAllByInmueble(PF_InmueblesInstance,[sort: "montoPrecio", order: "asc"])
        print PF_PreciosList[0]
        def PF_Preciomenor = PF_PreciosList[0]
        
        def PF_MultimediaList  = PF_Multimedia.findAllByInmueble(PF_InmueblesInstance,[sort: "url", order: "asc"]);
        def PF_MultimediaInstance = PF_MultimediaList[0]
        
        [PF_InmueblesInstance: PF_InmueblesInstance,PF_Preciomenor: PF_Preciomenor, PF_MultimediaInstance : PF_MultimediaInstance]
        
    }

    def edit(Long id) {
        def PF_InmueblesInstance = PF_Inmuebles.get(id)
        if (!PF_InmueblesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Inmuebles.label', default: 'PF_Inmuebles'), id])
            redirect(action: "list")
            return
        }

        [PF_InmueblesInstance: PF_InmueblesInstance]
    }

    def update(Long id, Long version) {
        def PF_InmueblesInstance = PF_Inmuebles.get(id)
        if (!PF_InmueblesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Inmuebles.label', default: 'PF_Inmuebles'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (PF_InmueblesInstance.version > version) {
                PF_InmueblesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'PF_Inmuebles.label', default: 'PF_Inmuebles')] as Object[],
                          "Another user has updated this PF_Inmuebles while you were editing")
                render(view: "edit", model: [PF_InmueblesInstance: PF_InmueblesInstance])
                return
            }
        }

        PF_InmueblesInstance.properties = params

        if (!PF_InmueblesInstance.save(flush: true)) {
            render(view: "edit", model: [PF_InmueblesInstance: PF_InmueblesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'PF_Inmuebles.label', default: 'PF_Inmuebles'), PF_InmueblesInstance.id])
        redirect(action: "show", id: PF_InmueblesInstance.id)
    }

    def delete(Long id) {
        def PF_InmueblesInstance = PF_Inmuebles.get(id)
        if (!PF_InmueblesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Inmuebles.label', default: 'PF_Inmuebles'), id])
            redirect(action: "list")
            return
        }

        try {
            PF_InmueblesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'PF_Inmuebles.label', default: 'PF_Inmuebles'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'PF_Inmuebles.label', default: 'PF_Inmuebles'), id])
            redirect(action: "show", id: id)
        }
    }
}
