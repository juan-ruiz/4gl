package pf4gl

import org.springframework.dao.DataIntegrityViolationException

class PF_PagosController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [PF_PagosInstanceList: PF_Pagos.list(params), PF_PagosInstanceTotal: PF_Pagos.count()]
    }

    def create() {
        [PF_PagosInstance: new PF_Pagos(params)]
    }

    def save() {
        def PF_PagosInstance = new PF_Pagos(params)
        if (!PF_PagosInstance.save(flush: true)) {
            render(view: "create", model: [PF_PagosInstance: PF_PagosInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'PF_Pagos.label', default: 'PF_Pagos'), PF_PagosInstance.id])
        redirect(action: "show", id: PF_PagosInstance.id)
    }

    def show(Long id) {
        def PF_PagosInstance = PF_Pagos.get(id)
        if (!PF_PagosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Pagos.label', default: 'PF_Pagos'), id])
            redirect(action: "list")
            return
        }

        [PF_PagosInstance: PF_PagosInstance]
    }

    def edit(Long id) {
        def PF_PagosInstance = PF_Pagos.get(id)
        if (!PF_PagosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Pagos.label', default: 'PF_Pagos'), id])
            redirect(action: "list")
            return
        }

        [PF_PagosInstance: PF_PagosInstance]
    }

    def update(Long id, Long version) {
        def PF_PagosInstance = PF_Pagos.get(id)
        if (!PF_PagosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Pagos.label', default: 'PF_Pagos'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (PF_PagosInstance.version > version) {
                PF_PagosInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'PF_Pagos.label', default: 'PF_Pagos')] as Object[],
                          "Another user has updated this PF_Pagos while you were editing")
                render(view: "edit", model: [PF_PagosInstance: PF_PagosInstance])
                return
            }
        }

        PF_PagosInstance.properties = params

        if (!PF_PagosInstance.save(flush: true)) {
            render(view: "edit", model: [PF_PagosInstance: PF_PagosInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'PF_Pagos.label', default: 'PF_Pagos'), PF_PagosInstance.id])
        redirect(action: "show", id: PF_PagosInstance.id)
    }

    def delete(Long id) {
        def PF_PagosInstance = PF_Pagos.get(id)
        if (!PF_PagosInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Pagos.label', default: 'PF_Pagos'), id])
            redirect(action: "list")
            return
        }

        try {
            PF_PagosInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'PF_Pagos.label', default: 'PF_Pagos'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'PF_Pagos.label', default: 'PF_Pagos'), id])
            redirect(action: "show", id: id)
        }
    }
}
