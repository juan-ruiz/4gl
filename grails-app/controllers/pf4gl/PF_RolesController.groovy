package pf4gl

import org.springframework.dao.DataIntegrityViolationException

class PF_RolesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [PF_RolesInstanceList: PF_Roles.list(params), PF_RolesInstanceTotal: PF_Roles.count()]
    }

    def create() {
        [PF_RolesInstance: new PF_Roles(params)]
    }

    def save() {
        def PF_RolesInstance = new PF_Roles(params)
        if (!PF_RolesInstance.save(flush: true)) {
            render(view: "create", model: [PF_RolesInstance: PF_RolesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'PF_Roles.label', default: 'PF_Roles'), PF_RolesInstance.id])
        redirect(action: "show", id: PF_RolesInstance.id)
    }

    def show(Long id) {
        def PF_RolesInstance = PF_Roles.get(id)
        if (!PF_RolesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Roles.label', default: 'PF_Roles'), id])
            redirect(action: "list")
            return
        }

        [PF_RolesInstance: PF_RolesInstance]
    }

    def edit(Long id) {
        def PF_RolesInstance = PF_Roles.get(id)
        if (!PF_RolesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Roles.label', default: 'PF_Roles'), id])
            redirect(action: "list")
            return
        }

        [PF_RolesInstance: PF_RolesInstance]
    }

    def update(Long id, Long version) {
        def PF_RolesInstance = PF_Roles.get(id)
        if (!PF_RolesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Roles.label', default: 'PF_Roles'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (PF_RolesInstance.version > version) {
                PF_RolesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'PF_Roles.label', default: 'PF_Roles')] as Object[],
                          "Another user has updated this PF_Roles while you were editing")
                render(view: "edit", model: [PF_RolesInstance: PF_RolesInstance])
                return
            }
        }

        PF_RolesInstance.properties = params

        if (!PF_RolesInstance.save(flush: true)) {
            render(view: "edit", model: [PF_RolesInstance: PF_RolesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'PF_Roles.label', default: 'PF_Roles'), PF_RolesInstance.id])
        redirect(action: "show", id: PF_RolesInstance.id)
    }

    def delete(Long id) {
        def PF_RolesInstance = PF_Roles.get(id)
        if (!PF_RolesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'PF_Roles.label', default: 'PF_Roles'), id])
            redirect(action: "list")
            return
        }

        try {
            PF_RolesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'PF_Roles.label', default: 'PF_Roles'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'PF_Roles.label', default: 'PF_Roles'), id])
            redirect(action: "show", id: id)
        }
    }
}
