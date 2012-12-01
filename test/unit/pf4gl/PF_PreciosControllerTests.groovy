package pf4gl



import org.junit.*
import grails.test.mixin.*

@TestFor(PF_PreciosController)
@Mock(PF_Precios)
class PF_PreciosControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/PF_Precios/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.PF_PreciosInstanceList.size() == 0
        assert model.PF_PreciosInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.PF_PreciosInstance != null
    }

    void testSave() {
        controller.save()

        assert model.PF_PreciosInstance != null
        assert view == '/PF_Precios/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/PF_Precios/show/1'
        assert controller.flash.message != null
        assert PF_Precios.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Precios/list'

        populateValidParams(params)
        def PF_Precios = new PF_Precios(params)

        assert PF_Precios.save() != null

        params.id = PF_Precios.id

        def model = controller.show()

        assert model.PF_PreciosInstance == PF_Precios
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Precios/list'

        populateValidParams(params)
        def PF_Precios = new PF_Precios(params)

        assert PF_Precios.save() != null

        params.id = PF_Precios.id

        def model = controller.edit()

        assert model.PF_PreciosInstance == PF_Precios
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Precios/list'

        response.reset()

        populateValidParams(params)
        def PF_Precios = new PF_Precios(params)

        assert PF_Precios.save() != null

        // test invalid parameters in update
        params.id = PF_Precios.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/PF_Precios/edit"
        assert model.PF_PreciosInstance != null

        PF_Precios.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/PF_Precios/show/$PF_Precios.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        PF_Precios.clearErrors()

        populateValidParams(params)
        params.id = PF_Precios.id
        params.version = -1
        controller.update()

        assert view == "/PF_Precios/edit"
        assert model.PF_PreciosInstance != null
        assert model.PF_PreciosInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/PF_Precios/list'

        response.reset()

        populateValidParams(params)
        def PF_Precios = new PF_Precios(params)

        assert PF_Precios.save() != null
        assert PF_Precios.count() == 1

        params.id = PF_Precios.id

        controller.delete()

        assert PF_Precios.count() == 0
        assert PF_Precios.get(PF_Precios.id) == null
        assert response.redirectedUrl == '/PF_Precios/list'
    }
}
