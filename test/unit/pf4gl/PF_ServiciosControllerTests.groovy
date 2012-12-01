package pf4gl



import org.junit.*
import grails.test.mixin.*

@TestFor(PF_ServiciosController)
@Mock(PF_Servicios)
class PF_ServiciosControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/PF_Servicios/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.PF_ServiciosInstanceList.size() == 0
        assert model.PF_ServiciosInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.PF_ServiciosInstance != null
    }

    void testSave() {
        controller.save()

        assert model.PF_ServiciosInstance != null
        assert view == '/PF_Servicios/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/PF_Servicios/show/1'
        assert controller.flash.message != null
        assert PF_Servicios.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Servicios/list'

        populateValidParams(params)
        def PF_Servicios = new PF_Servicios(params)

        assert PF_Servicios.save() != null

        params.id = PF_Servicios.id

        def model = controller.show()

        assert model.PF_ServiciosInstance == PF_Servicios
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Servicios/list'

        populateValidParams(params)
        def PF_Servicios = new PF_Servicios(params)

        assert PF_Servicios.save() != null

        params.id = PF_Servicios.id

        def model = controller.edit()

        assert model.PF_ServiciosInstance == PF_Servicios
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Servicios/list'

        response.reset()

        populateValidParams(params)
        def PF_Servicios = new PF_Servicios(params)

        assert PF_Servicios.save() != null

        // test invalid parameters in update
        params.id = PF_Servicios.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/PF_Servicios/edit"
        assert model.PF_ServiciosInstance != null

        PF_Servicios.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/PF_Servicios/show/$PF_Servicios.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        PF_Servicios.clearErrors()

        populateValidParams(params)
        params.id = PF_Servicios.id
        params.version = -1
        controller.update()

        assert view == "/PF_Servicios/edit"
        assert model.PF_ServiciosInstance != null
        assert model.PF_ServiciosInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/PF_Servicios/list'

        response.reset()

        populateValidParams(params)
        def PF_Servicios = new PF_Servicios(params)

        assert PF_Servicios.save() != null
        assert PF_Servicios.count() == 1

        params.id = PF_Servicios.id

        controller.delete()

        assert PF_Servicios.count() == 0
        assert PF_Servicios.get(PF_Servicios.id) == null
        assert response.redirectedUrl == '/PF_Servicios/list'
    }
}
