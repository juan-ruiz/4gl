package pf4gl

import org.springframework.dao.DataIntegrityViolationException

class PF_ServiciosController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [PF_ServiciosInstanceList: PF_Servicios.list(params), PF_ServiciosInstanceTotal: PF_Servicios.count()]
    }

    def create() {
        [PF_ServiciosInstance: new PF_Servicios(params)]
    }

    def save() {
        def PF_ServiciosInstance = new PF_Servicios(params)
        if (!PF_ServiciosInstance.save(flush: true)) {
            render(view: "create", model: [PF_ServiciosInstance: PF_ServiciosInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'PF_Servicios.label', default: 'PF_Servicios'), PF_ServiciosInstance.id])
        redirect(action: "show", id: PF_ServiciosInstance.id)
    }

    def show(Long id) {
        def PF_ServiciosInstance = PF_Servicios.get(id)
        if (!PF_ServiciosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Servicios.label', default: 'PF_Servicios'), id])
            redirect(action: "list")
            return
        }

        [PF_ServiciosInstance: PF_ServiciosInstance]
    }

    def edit(Long id) {
        def PF_ServiciosInstance = PF_Servicios.get(id)
        if (!PF_ServiciosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Servicios.label', default: 'PF_Servicios'), id])
            redirect(action: "list")
            return
        }

        [PF_ServiciosInstance: PF_ServiciosInstance]
    }

    def update(Long id, Long version) {
        def PF_ServiciosInstance = PF_Servicios.get(id)
        if (!PF_ServiciosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Servicios.label', default: 'PF_Servicios'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (PF_ServiciosInstance.version > version) {
                PF_ServiciosInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'PF_Servicios.label', default: 'PF_Servicios')] as Object[],
                          "Another user has updated this PF_Servicios while you were editing")
                render(view: "edit", model: [PF_ServiciosInstance: PF_ServiciosInstance])
                return
            }
        }

        PF_ServiciosInstance.properties = params

        if (!PF_ServiciosInstance.save(flush: true)) {
            render(view: "edit", model: [PF_ServiciosInstance: PF_ServiciosInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'PF_Servicios.label', default: 'PF_Servicios'), PF_ServiciosInstance.id])
        redirect(action: "show", id: PF_ServiciosInstance.id)
    }

    def delete(Long id) {
        def PF_ServiciosInstance = PF_Servicios.get(id)
        if (!PF_ServiciosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Servicios.label', default: 'PF_Servicios'), id])
            redirect(action: "list")
            return
        }

        try {
            PF_ServiciosInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'PF_Servicios.label', default: 'PF_Servicios'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'PF_Servicios.label', default: 'PF_Servicios'), id])
            redirect(action: "show", id: id)
        }
    }
}
