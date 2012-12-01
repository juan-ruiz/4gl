package pf4gl

import org.springframework.dao.DataIntegrityViolationException

class PF_RecomendacionesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [PF_RecomendacionesInstanceList: PF_Recomendaciones.list(params), PF_RecomendacionesInstanceTotal: PF_Recomendaciones.count()]
    }

    def create() {
        [PF_RecomendacionesInstance: new PF_Recomendaciones(params)]
    }

    def save() {
        def PF_RecomendacionesInstance = new PF_Recomendaciones(params)
        if (!PF_RecomendacionesInstance.save(flush: true)) {
            render(view: "create", model: [PF_RecomendacionesInstance: PF_RecomendacionesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'PF_Recomendaciones.label', default: 'PF_Recomendaciones'), PF_RecomendacionesInstance.id])
        redirect(action: "show", id: PF_RecomendacionesInstance.id)
    }

    def show(Long id) {
        def PF_RecomendacionesInstance = PF_Recomendaciones.get(id)
        if (!PF_RecomendacionesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Recomendaciones.label', default: 'PF_Recomendaciones'), id])
            redirect(action: "list")
            return
        }

        [PF_RecomendacionesInstance: PF_RecomendacionesInstance]
    }

    def edit(Long id) {
        def PF_RecomendacionesInstance = PF_Recomendaciones.get(id)
        if (!PF_RecomendacionesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Recomendaciones.label', default: 'PF_Recomendaciones'), id])
            redirect(action: "list")
            return
        }

        [PF_RecomendacionesInstance: PF_RecomendacionesInstance]
    }

    def update(Long id, Long version) {
        def PF_RecomendacionesInstance = PF_Recomendaciones.get(id)
        if (!PF_RecomendacionesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Recomendaciones.label', default: 'PF_Recomendaciones'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (PF_RecomendacionesInstance.version > version) {
                PF_RecomendacionesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'PF_Recomendaciones.label', default: 'PF_Recomendaciones')] as Object[],
                          "Another user has updated this PF_Recomendaciones while you were editing")
                render(view: "edit", model: [PF_RecomendacionesInstance: PF_RecomendacionesInstance])
                return
            }
        }

        PF_RecomendacionesInstance.properties = params

        if (!PF_RecomendacionesInstance.save(flush: true)) {
            render(view: "edit", model: [PF_RecomendacionesInstance: PF_RecomendacionesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'PF_Recomendaciones.label', default: 'PF_Recomendaciones'), PF_RecomendacionesInstance.id])
        redirect(action: "show", id: PF_RecomendacionesInstance.id)
    }

    def delete(Long id) {
        def PF_RecomendacionesInstance = PF_Recomendaciones.get(id)
        if (!PF_RecomendacionesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Recomendaciones.label', default: 'PF_Recomendaciones'), id])
            redirect(action: "list")
            return
        }

        try {
            PF_RecomendacionesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'PF_Recomendaciones.label', default: 'PF_Recomendaciones'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'PF_Recomendaciones.label', default: 'PF_Recomendaciones'), id])
            redirect(action: "show", id: id)
        }
    }
}
