package pf4gl

import org.springframework.dao.DataIntegrityViolationException

class PF_PaisesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [PF_PaisesInstanceList: PF_Paises.list(params), PF_PaisesInstanceTotal: PF_Paises.count()]
    }

    def create() {
        [PF_PaisesInstance: new PF_Paises(params)]
    }

    def save() {
        def PF_PaisesInstance = new PF_Paises(params)
        if (!PF_PaisesInstance.save(flush: true)) {
            render(view: "create", model: [PF_PaisesInstance: PF_PaisesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'PF_Paises.label', default: 'PF_Paises'), PF_PaisesInstance.id])
        redirect(action: "show", id: PF_PaisesInstance.id)
    }

    def show(Long id) {
        def PF_PaisesInstance = PF_Paises.get(id)
        if (!PF_PaisesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Paises.label', default: 'PF_Paises'), id])
            redirect(action: "list")
            return
        }

        [PF_PaisesInstance: PF_PaisesInstance]
    }

    def edit(Long id) {
        def PF_PaisesInstance = PF_Paises.get(id)
        if (!PF_PaisesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Paises.label', default: 'PF_Paises'), id])
            redirect(action: "list")
            return
        }

        [PF_PaisesInstance: PF_PaisesInstance]
    }

    def update(Long id, Long version) {
        def PF_PaisesInstance = PF_Paises.get(id)
        if (!PF_PaisesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Paises.label', default: 'PF_Paises'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (PF_PaisesInstance.version > version) {
                PF_PaisesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'PF_Paises.label', default: 'PF_Paises')] as Object[],
                          "Another user has updated this PF_Paises while you were editing")
                render(view: "edit", model: [PF_PaisesInstance: PF_PaisesInstance])
                return
            }
        }

        PF_PaisesInstance.properties = params

        if (!PF_PaisesInstance.save(flush: true)) {
            render(view: "edit", model: [PF_PaisesInstance: PF_PaisesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'PF_Paises.label', default: 'PF_Paises'), PF_PaisesInstance.id])
        redirect(action: "show", id: PF_PaisesInstance.id)
    }

    def delete(Long id) {
        def PF_PaisesInstance = PF_Paises.get(id)
        if (!PF_PaisesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Paises.label', default: 'PF_Paises'), id])
            redirect(action: "list")
            return
        }

        try {
            PF_PaisesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'PF_Paises.label', default: 'PF_Paises'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'PF_Paises.label', default: 'PF_Paises'), id])
            redirect(action: "show", id: id)
        }
    }
}
