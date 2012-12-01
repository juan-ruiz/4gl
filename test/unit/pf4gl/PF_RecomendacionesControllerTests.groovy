package pf4gl



import org.junit.*
import grails.test.mixin.*

@TestFor(PF_RecomendacionesController)
@Mock(PF_Recomendaciones)
class PF_RecomendacionesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/PF_Recomendaciones/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.PF_RecomendacionesInstanceList.size() == 0
        assert model.PF_RecomendacionesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.PF_RecomendacionesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.PF_RecomendacionesInstance != null
        assert view == '/PF_Recomendaciones/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/PF_Recomendaciones/show/1'
        assert controller.flash.message != null
        assert PF_Recomendaciones.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Recomendaciones/list'

        populateValidParams(params)
        def PF_Recomendaciones = new PF_Recomendaciones(params)

        assert PF_Recomendaciones.save() != null

        params.id = PF_Recomendaciones.id

        def model = controller.show()

        assert model.PF_RecomendacionesInstance == PF_Recomendaciones
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Recomendaciones/list'

        populateValidParams(params)
        def PF_Recomendaciones = new PF_Recomendaciones(params)

        assert PF_Recomendaciones.save() != null

        params.id = PF_Recomendaciones.id

        def model = controller.edit()

        assert model.PF_RecomendacionesInstance == PF_Recomendaciones
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Recomendaciones/list'

        response.reset()

        populateValidParams(params)
        def PF_Recomendaciones = new PF_Recomendaciones(params)

        assert PF_Recomendaciones.save() != null

        // test invalid parameters in update
        params.id = PF_Recomendaciones.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/PF_Recomendaciones/edit"
        assert model.PF_RecomendacionesInstance != null

        PF_Recomendaciones.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/PF_Recomendaciones/show/$PF_Recomendaciones.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        PF_Recomendaciones.clearErrors()

        populateValidParams(params)
        params.id = PF_Recomendaciones.id
        params.version = -1
        controller.update()

        assert view == "/PF_Recomendaciones/edit"
        assert model.PF_RecomendacionesInstance != null
        assert model.PF_RecomendacionesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/PF_Recomendaciones/list'

        response.reset()

        populateValidParams(params)
        def PF_Recomendaciones = new PF_Recomendaciones(params)

        assert PF_Recomendaciones.save() != null
        assert PF_Recomendaciones.count() == 1

        params.id = PF_Recomendaciones.id

        controller.delete()

        assert PF_Recomendaciones.count() == 0
        assert PF_Recomendaciones.get(PF_Recomendaciones.id) == null
        assert response.redirectedUrl == '/PF_Recomendaciones/list'
    }
}
