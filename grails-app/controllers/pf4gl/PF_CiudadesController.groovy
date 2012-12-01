package pf4gl

import org.springframework.dao.DataIntegrityViolationException

class PF_CiudadesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [PF_CiudadesInstanceList: PF_Ciudades.list(params), PF_CiudadesInstanceTotal: PF_Ciudades.count()]
    }

    def create() {
        [PF_CiudadesInstance: new PF_Ciudades(params)]
    }

    def save() {
        def PF_CiudadesInstance = new PF_Ciudades(params)
        if (!PF_CiudadesInstance.save(flush: true)) {
            render(view: "create", model: [PF_CiudadesInstance: PF_CiudadesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'PF_Ciudades.label', default: 'PF_Ciudades'), PF_CiudadesInstance.id])
        redirect(action: "show", id: PF_CiudadesInstance.id)
    }

    def show(Long id) {
        def PF_CiudadesInstance = PF_Ciudades.get(id)
        if (!PF_CiudadesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Ciudades.label', default: 'PF_Ciudades'), id])
            redirect(action: "list")
            return
        }

        [PF_CiudadesInstance: PF_CiudadesInstance]
    }

    def edit(Long id) {
        def PF_CiudadesInstance = PF_Ciudades.get(id)
        if (!PF_CiudadesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Ciudades.label', default: 'PF_Ciudades'), id])
            redirect(action: "list")
            return
        }

        [PF_CiudadesInstance: PF_CiudadesInstance]
    }

    def update(Long id, Long version) {
        def PF_CiudadesInstance = PF_Ciudades.get(id)
        if (!PF_CiudadesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Ciudades.label', default: 'PF_Ciudades'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (PF_CiudadesInstance.version > version) {
                PF_CiudadesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'PF_Ciudades.label', default: 'PF_Ciudades')] as Object[],
                          "Another user has updated this PF_Ciudades while you were editing")
                render(view: "edit", model: [PF_CiudadesInstance: PF_CiudadesInstance])
                return
            }
        }

        PF_CiudadesInstance.properties = params

        if (!PF_CiudadesInstance.save(flush: true)) {
            render(view: "edit", model: [PF_CiudadesInstance: PF_CiudadesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'PF_Ciudades.label', default: 'PF_Ciudades'), PF_CiudadesInstance.id])
        redirect(action: "show", id: PF_CiudadesInstance.id)
    }

    def delete(Long id) {
        def PF_CiudadesInstance = PF_Ciudades.get(id)
        if (!PF_CiudadesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Ciudades.label', default: 'PF_Ciudades'), id])
            redirect(action: "list")
            return
        }

        try {
            PF_CiudadesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'PF_Ciudades.label', default: 'PF_Ciudades'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'PF_Ciudades.label', default: 'PF_Ciudades'), id])
            redirect(action: "show", id: id)
        }
    }
}
