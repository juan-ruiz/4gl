package pf4gl



import org.junit.*
import grails.test.mixin.*

@TestFor(PF_UsuariosController)
@Mock(PF_Usuarios)
class PF_UsuariosControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/PF_Usuarios/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.PF_UsuariosInstanceList.size() == 0
        assert model.PF_UsuariosInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.PF_UsuariosInstance != null
    }

    void testSave() {
        controller.save()

        assert model.PF_UsuariosInstance != null
        assert view == '/PF_Usuarios/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/PF_Usuarios/show/1'
        assert controller.flash.message != null
        assert PF_Usuarios.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Usuarios/list'

        populateValidParams(params)
        def PF_Usuarios = new PF_Usuarios(params)

        assert PF_Usuarios.save() != null

        params.id = PF_Usuarios.id

        def model = controller.show()

        assert model.PF_UsuariosInstance == PF_Usuarios
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Usuarios/list'

        populateValidParams(params)
        def PF_Usuarios = new PF_Usuarios(params)

        assert PF_Usuarios.save() != null

        params.id = PF_Usuarios.id

        def model = controller.edit()

        assert model.PF_UsuariosInstance == PF_Usuarios
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Usuarios/list'

        response.reset()

        populateValidParams(params)
        def PF_Usuarios = new PF_Usuarios(params)

        assert PF_Usuarios.save() != null

        // test invalid parameters in update
        params.id = PF_Usuarios.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/PF_Usuarios/edit"
        assert model.PF_UsuariosInstance != null

        PF_Usuarios.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/PF_Usuarios/show/$PF_Usuarios.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        PF_Usuarios.clearErrors()

        populateValidParams(params)
        params.id = PF_Usuarios.id
        params.version = -1
        controller.update()

        assert view == "/PF_Usuarios/edit"
        assert model.PF_UsuariosInstance != null
        assert model.PF_UsuariosInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/PF_Usuarios/list'

        response.reset()

        populateValidParams(params)
        def PF_Usuarios = new PF_Usuarios(params)

        assert PF_Usuarios.save() != null
        assert PF_Usuarios.count() == 1

        params.id = PF_Usuarios.id

        controller.delete()

        assert PF_Usuarios.count() == 0
        assert PF_Usuarios.get(PF_Usuarios.id) == null
        assert response.redirectedUrl == '/PF_Usuarios/list'
    }
}
