package pf4gl

import org.springframework.dao.DataIntegrityViolationException

class PF_MensajesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [PF_MensajesInstanceList: PF_Mensajes.list(params), PF_MensajesInstanceTotal: PF_Mensajes.count()]
    }

    def create() {
        [PF_MensajesInstance: new PF_Mensajes(params)]
    }

    def save() {
        def PF_MensajesInstance = new PF_Mensajes(params)
        if (!PF_MensajesInstance.save(flush: true)) {
            render(view: "create", model: [PF_MensajesInstance: PF_MensajesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'PF_Mensajes.label', default: 'PF_Mensajes'), PF_MensajesInstance.id])
        redirect(action: "show", id: PF_MensajesInstance.id)
    }

    def show(Long id) {
        def PF_MensajesInstance = PF_Mensajes.get(id)
        if (!PF_MensajesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Mensajes.label', default: 'PF_Mensajes'), id])
            redirect(action: "list")
            return
        }

        [PF_MensajesInstance: PF_MensajesInstance]
    }

    def edit(Long id) {
        def PF_MensajesInstance = PF_Mensajes.get(id)
        if (!PF_MensajesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Mensajes.label', default: 'PF_Mensajes'), id])
            redirect(action: "list")
            return
        }

        [PF_MensajesInstance: PF_MensajesInstance]
    }

    def update(Long id, Long version) {
        def PF_MensajesInstance = PF_Mensajes.get(id)
        if (!PF_MensajesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Mensajes.label', default: 'PF_Mensajes'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (PF_MensajesInstance.version > version) {
                PF_MensajesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'PF_Mensajes.label', default: 'PF_Mensajes')] as Object[],
                          "Another user has updated this PF_Mensajes while you were editing")
                render(view: "edit", model: [PF_MensajesInstance: PF_MensajesInstance])
                return
            }
        }

        PF_MensajesInstance.properties = params

        if (!PF_MensajesInstance.save(flush: true)) {
            render(view: "edit", model: [PF_MensajesInstance: PF_MensajesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'PF_Mensajes.label', default: 'PF_Mensajes'), PF_MensajesInstance.id])
        redirect(action: "show", id: PF_MensajesInstance.id)
    }

    def delete(Long id) {
        def PF_MensajesInstance = PF_Mensajes.get(id)
        if (!PF_MensajesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Mensajes.label', default: 'PF_Mensajes'), id])
            redirect(action: "list")
            return
        }

        try {
            PF_MensajesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'PF_Mensajes.label', default: 'PF_Mensajes'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'PF_Mensajes.label', default: 'PF_Mensajes'), id])
            redirect(action: "show", id: id)
        }
    }
}
