package pf4gl



import org.junit.*
import grails.test.mixin.*

@TestFor(PF_ReservasController)
@Mock(PF_Reservas)
class PF_ReservasControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/PF_Reservas/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.PF_ReservasInstanceList.size() == 0
        assert model.PF_ReservasInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.PF_ReservasInstance != null
    }

    void testSave() {
        controller.save()

        assert model.PF_ReservasInstance != null
        assert view == '/PF_Reservas/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/PF_Reservas/show/1'
        assert controller.flash.message != null
        assert PF_Reservas.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Reservas/list'

        populateValidParams(params)
        def PF_Reservas = new PF_Reservas(params)

        assert PF_Reservas.save() != null

        params.id = PF_Reservas.id

        def model = controller.show()

        assert model.PF_ReservasInstance == PF_Reservas
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Reservas/list'

        populateValidParams(params)
        def PF_Reservas = new PF_Reservas(params)

        assert PF_Reservas.save() != null

        params.id = PF_Reservas.id

        def model = controller.edit()

        assert model.PF_ReservasInstance == PF_Reservas
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Reservas/list'

        response.reset()

        populateValidParams(params)
        def PF_Reservas = new PF_Reservas(params)

        assert PF_Reservas.save() != null

        // test invalid parameters in update
        params.id = PF_Reservas.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/PF_Reservas/edit"
        assert model.PF_ReservasInstance != null

        PF_Reservas.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/PF_Reservas/show/$PF_Reservas.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        PF_Reservas.clearErrors()

        populateValidParams(params)
        params.id = PF_Reservas.id
        params.version = -1
        controller.update()

        assert view == "/PF_Reservas/edit"
        assert model.PF_ReservasInstance != null
        assert model.PF_ReservasInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/PF_Reservas/list'

        response.reset()

        populateValidParams(params)
        def PF_Reservas = new PF_Reservas(params)

        assert PF_Reservas.save() != null
        assert PF_Reservas.count() == 1

        params.id = PF_Reservas.id

        controller.delete()

        assert PF_Reservas.count() == 0
        assert PF_Reservas.get(PF_Reservas.id) == null
        assert response.redirectedUrl == '/PF_Reservas/list'
    }
}
