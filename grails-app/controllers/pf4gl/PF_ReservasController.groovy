package pf4gl

import org.springframework.dao.DataIntegrityViolationException

class PF_ReservasController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [PF_ReservasInstanceList: PF_Reservas.list(params), PF_ReservasInstanceTotal: PF_Reservas.count()]
    }

    def create() {
        [PF_ReservasInstance: new PF_Reservas(params)]
    }

    def save() {
        def PF_ReservasInstance = new PF_Reservas(params)
        if (!PF_ReservasInstance.save(flush: true)) {
            render(view: "create", model: [PF_ReservasInstance: PF_ReservasInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'PF_Reservas.label', default: 'PF_Reservas'), PF_ReservasInstance.id])
        redirect(action: "show", id: PF_ReservasInstance.id)
    }

    def show(Long id) {
        def PF_ReservasInstance = PF_Reservas.get(id)
        if (!PF_ReservasInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Reservas.label', default: 'PF_Reservas'), id])
            redirect(action: "list")
            return
        }

        [PF_ReservasInstance: PF_ReservasInstance]
    }

    def edit(Long id) {
        def PF_ReservasInstance = PF_Reservas.get(id)
        if (!PF_ReservasInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Reservas.label', default: 'PF_Reservas'), id])
            redirect(action: "list")
            return
        }

        [PF_ReservasInstance: PF_ReservasInstance]
    }

    def update(Long id, Long version) {
        def PF_ReservasInstance = PF_Reservas.get(id)
        if (!PF_ReservasInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Reservas.label', default: 'PF_Reservas'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (PF_ReservasInstance.version > version) {
                PF_ReservasInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'PF_Reservas.label', default: 'PF_Reservas')] as Object[],
                          "Another user has updated this PF_Reservas while you were editing")
                render(view: "edit", model: [PF_ReservasInstance: PF_ReservasInstance])
                return
            }
        }

        PF_ReservasInstance.properties = params

        if (!PF_ReservasInstance.save(flush: true)) {
            render(view: "edit", model: [PF_ReservasInstance: PF_ReservasInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'PF_Reservas.label', default: 'PF_Reservas'), PF_ReservasInstance.id])
        redirect(action: "show", id: PF_ReservasInstance.id)
    }

    def delete(Long id) {
        def PF_ReservasInstance = PF_Reservas.get(id)
        if (!PF_ReservasInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Reservas.label', default: 'PF_Reservas'), id])
            redirect(action: "list")
            return
        }

        try {
            PF_ReservasInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'PF_Reservas.label', default: 'PF_Reservas'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'PF_Reservas.label', default: 'PF_Reservas'), id])
            redirect(action: "show", id: id)
        }
    }
}
