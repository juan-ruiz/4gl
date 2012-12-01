package pf4gl



import org.junit.*
import grails.test.mixin.*

@TestFor(PF_PagosController)
@Mock(PF_Pagos)
class PF_PagosControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/PF_Pagos/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.PF_PagosInstanceList.size() == 0
        assert model.PF_PagosInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.PF_PagosInstance != null
    }

    void testSave() {
        controller.save()

        assert model.PF_PagosInstance != null
        assert view == '/PF_Pagos/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/PF_Pagos/show/1'
        assert controller.flash.message != null
        assert PF_Pagos.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Pagos/list'

        populateValidParams(params)
        def PF_Pagos = new PF_Pagos(params)

        assert PF_Pagos.save() != null

        params.id = PF_Pagos.id

        def model = controller.show()

        assert model.PF_PagosInstance == PF_Pagos
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Pagos/list'

        populateValidParams(params)
        def PF_Pagos = new PF_Pagos(params)

        assert PF_Pagos.save() != null

        params.id = PF_Pagos.id

        def model = controller.edit()

        assert model.PF_PagosInstance == PF_Pagos
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Pagos/list'

        response.reset()

        populateValidParams(params)
        def PF_Pagos = new PF_Pagos(params)

        assert PF_Pagos.save() != null

        // test invalid parameters in update
        params.id = PF_Pagos.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/PF_Pagos/edit"
        assert model.PF_PagosInstance != null

        PF_Pagos.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/PF_Pagos/show/$PF_Pagos.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        PF_Pagos.clearErrors()

        populateValidParams(params)
        params.id = PF_Pagos.id
        params.version = -1
        controller.update()

        assert view == "/PF_Pagos/edit"
        assert model.PF_PagosInstance != null
        assert model.PF_PagosInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/PF_Pagos/list'

        response.reset()

        populateValidParams(params)
        def PF_Pagos = new PF_Pagos(params)

        assert PF_Pagos.save() != null
        assert PF_Pagos.count() == 1

        params.id = PF_Pagos.id

        controller.delete()

        assert PF_Pagos.count() == 0
        assert PF_Pagos.get(PF_Pagos.id) == null
        assert response.redirectedUrl == '/PF_Pagos/list'
    }
}
