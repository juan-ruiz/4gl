package pf4gl

import org.springframework.dao.DataIntegrityViolationException

class PF_PreciosController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [PF_PreciosInstanceList: PF_Precios.list(params), PF_PreciosInstanceTotal: PF_Precios.count()]
    }

    def create() {
        [PF_PreciosInstance: new PF_Precios(params)]
    }

    def save() {
        def PF_PreciosInstance = new PF_Precios(params)
        if (!PF_PreciosInstance.save(flush: true)) {
            render(view: "create", model: [PF_PreciosInstance: PF_PreciosInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'PF_Precios.label', default: 'PF_Precios'), PF_PreciosInstance.id])
        redirect(action: "show", id: PF_PreciosInstance.id)
    }

    def show(Long id) {
        def PF_PreciosInstance = PF_Precios.get(id)
        if (!PF_PreciosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Precios.label', default: 'PF_Precios'), id])
            redirect(action: "list")
            return
        }

        [PF_PreciosInstance: PF_PreciosInstance]
    }

    def edit(Long id) {
        def PF_PreciosInstance = PF_Precios.get(id)
        if (!PF_PreciosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Precios.label', default: 'PF_Precios'), id])
            redirect(action: "list")
            return
        }

        [PF_PreciosInstance: PF_PreciosInstance]
    }

    def update(Long id, Long version) {
        def PF_PreciosInstance = PF_Precios.get(id)
        if (!PF_PreciosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Precios.label', default: 'PF_Precios'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (PF_PreciosInstance.version > version) {
                PF_PreciosInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'PF_Precios.label', default: 'PF_Precios')] as Object[],
                          "Another user has updated this PF_Precios while you were editing")
                render(view: "edit", model: [PF_PreciosInstance: PF_PreciosInstance])
                return
            }
        }

        PF_PreciosInstance.properties = params

        if (!PF_PreciosInstance.save(flush: true)) {
            render(view: "edit", model: [PF_PreciosInstance: PF_PreciosInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'PF_Precios.label', default: 'PF_Precios'), PF_PreciosInstance.id])
        redirect(action: "show", id: PF_PreciosInstance.id)
    }

    def delete(Long id) {
        def PF_PreciosInstance = PF_Precios.get(id)
        if (!PF_PreciosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Precios.label', default: 'PF_Precios'), id])
            redirect(action: "list")
            return
        }

        try {
            PF_PreciosInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'PF_Precios.label', default: 'PF_Precios'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'PF_Precios.label', default: 'PF_Precios'), id])
            redirect(action: "show", id: id)
        }
    }
}
