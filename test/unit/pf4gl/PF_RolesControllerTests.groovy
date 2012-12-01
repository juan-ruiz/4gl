package pf4gl



import org.junit.*
import grails.test.mixin.*

@TestFor(PF_RolesController)
@Mock(PF_Roles)
class PF_RolesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/PF_Roles/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.PF_RolesInstanceList.size() == 0
        assert model.PF_RolesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.PF_RolesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.PF_RolesInstance != null
        assert view == '/PF_Roles/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/PF_Roles/show/1'
        assert controller.flash.message != null
        assert PF_Roles.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Roles/list'

        populateValidParams(params)
        def PF_Roles = new PF_Roles(params)

        assert PF_Roles.save() != null

        params.id = PF_Roles.id

        def model = controller.show()

        assert model.PF_RolesInstance == PF_Roles
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Roles/list'

        populateValidParams(params)
        def PF_Roles = new PF_Roles(params)

        assert PF_Roles.save() != null

        params.id = PF_Roles.id

        def model = controller.edit()

        assert model.PF_RolesInstance == PF_Roles
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Roles/list'

        response.reset()

        populateValidParams(params)
        def PF_Roles = new PF_Roles(params)

        assert PF_Roles.save() != null

        // test invalid parameters in update
        params.id = PF_Roles.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/PF_Roles/edit"
        assert model.PF_RolesInstance != null

        PF_Roles.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/PF_Roles/show/$PF_Roles.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        PF_Roles.clearErrors()

        populateValidParams(params)
        params.id = PF_Roles.id
        params.version = -1
        controller.update()

        assert view == "/PF_Roles/edit"
        assert model.PF_RolesInstance != null
        assert model.PF_RolesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/PF_Roles/list'

        response.reset()

        populateValidParams(params)
        def PF_Roles = new PF_Roles(params)

        assert PF_Roles.save() != null
        assert PF_Roles.count() == 1

        params.id = PF_Roles.id

        controller.delete()

        assert PF_Roles.count() == 0
        assert PF_Roles.get(PF_Roles.id) == null
        assert response.redirectedUrl == '/PF_Roles/list'
    }
}
