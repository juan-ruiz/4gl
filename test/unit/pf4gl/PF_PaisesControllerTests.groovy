package pf4gl



import org.junit.*
import grails.test.mixin.*

@TestFor(PF_PaisesController)
@Mock(PF_Paises)
class PF_PaisesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/PF_Paises/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.PF_PaisesInstanceList.size() == 0
        assert model.PF_PaisesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.PF_PaisesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.PF_PaisesInstance != null
        assert view == '/PF_Paises/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/PF_Paises/show/1'
        assert controller.flash.message != null
        assert PF_Paises.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Paises/list'

        populateValidParams(params)
        def PF_Paises = new PF_Paises(params)

        assert PF_Paises.save() != null

        params.id = PF_Paises.id

        def model = controller.show()

        assert model.PF_PaisesInstance == PF_Paises
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Paises/list'

        populateValidParams(params)
        def PF_Paises = new PF_Paises(params)

        assert PF_Paises.save() != null

        params.id = PF_Paises.id

        def model = controller.edit()

        assert model.PF_PaisesInstance == PF_Paises
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Paises/list'

        response.reset()

        populateValidParams(params)
        def PF_Paises = new PF_Paises(params)

        assert PF_Paises.save() != null

        // test invalid parameters in update
        params.id = PF_Paises.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/PF_Paises/edit"
        assert model.PF_PaisesInstance != null

        PF_Paises.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/PF_Paises/show/$PF_Paises.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        PF_Paises.clearErrors()

        populateValidParams(params)
        params.id = PF_Paises.id
        params.version = -1
        controller.update()

        assert view == "/PF_Paises/edit"
        assert model.PF_PaisesInstance != null
        assert model.PF_PaisesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/PF_Paises/list'

        response.reset()

        populateValidParams(params)
        def PF_Paises = new PF_Paises(params)

        assert PF_Paises.save() != null
        assert PF_Paises.count() == 1

        params.id = PF_Paises.id

        controller.delete()

        assert PF_Paises.count() == 0
        assert PF_Paises.get(PF_Paises.id) == null
        assert response.redirectedUrl == '/PF_Paises/list'
    }
}
