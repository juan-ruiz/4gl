package pf4gl



import org.junit.*
import grails.test.mixin.*

@TestFor(PF_MensajesController)
@Mock(PF_Mensajes)
class PF_MensajesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/PF_Mensajes/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.PF_MensajesInstanceList.size() == 0
        assert model.PF_MensajesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.PF_MensajesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.PF_MensajesInstance != null
        assert view == '/PF_Mensajes/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/PF_Mensajes/show/1'
        assert controller.flash.message != null
        assert PF_Mensajes.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Mensajes/list'

        populateValidParams(params)
        def PF_Mensajes = new PF_Mensajes(params)

        assert PF_Mensajes.save() != null

        params.id = PF_Mensajes.id

        def model = controller.show()

        assert model.PF_MensajesInstance == PF_Mensajes
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Mensajes/list'

        populateValidParams(params)
        def PF_Mensajes = new PF_Mensajes(params)

        assert PF_Mensajes.save() != null

        params.id = PF_Mensajes.id

        def model = controller.edit()

        assert model.PF_MensajesInstance == PF_Mensajes
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Mensajes/list'

        response.reset()

        populateValidParams(params)
        def PF_Mensajes = new PF_Mensajes(params)

        assert PF_Mensajes.save() != null

        // test invalid parameters in update
        params.id = PF_Mensajes.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/PF_Mensajes/edit"
        assert model.PF_MensajesInstance != null

        PF_Mensajes.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/PF_Mensajes/show/$PF_Mensajes.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        PF_Mensajes.clearErrors()

        populateValidParams(params)
        params.id = PF_Mensajes.id
        params.version = -1
        controller.update()

        assert view == "/PF_Mensajes/edit"
        assert model.PF_MensajesInstance != null
        assert model.PF_MensajesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/PF_Mensajes/list'

        response.reset()

        populateValidParams(params)
        def PF_Mensajes = new PF_Mensajes(params)

        assert PF_Mensajes.save() != null
        assert PF_Mensajes.count() == 1

        params.id = PF_Mensajes.id

        controller.delete()

        assert PF_Mensajes.count() == 0
        assert PF_Mensajes.get(PF_Mensajes.id) == null
        assert response.redirectedUrl == '/PF_Mensajes/list'
    }
}
