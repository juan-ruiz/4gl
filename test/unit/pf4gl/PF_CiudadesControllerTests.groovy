package pf4gl



import org.junit.*
import grails.test.mixin.*

@TestFor(PF_CiudadesController)
@Mock(PF_Ciudades)
class PF_CiudadesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/PF_Ciudades/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.PF_CiudadesInstanceList.size() == 0
        assert model.PF_CiudadesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.PF_CiudadesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.PF_CiudadesInstance != null
        assert view == '/PF_Ciudades/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/PF_Ciudades/show/1'
        assert controller.flash.message != null
        assert PF_Ciudades.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Ciudades/list'

        populateValidParams(params)
        def PF_Ciudades = new PF_Ciudades(params)

        assert PF_Ciudades.save() != null

        params.id = PF_Ciudades.id

        def model = controller.show()

        assert model.PF_CiudadesInstance == PF_Ciudades
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Ciudades/list'

        populateValidParams(params)
        def PF_Ciudades = new PF_Ciudades(params)

        assert PF_Ciudades.save() != null

        params.id = PF_Ciudades.id

        def model = controller.edit()

        assert model.PF_CiudadesInstance == PF_Ciudades
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Ciudades/list'

        response.reset()

        populateValidParams(params)
        def PF_Ciudades = new PF_Ciudades(params)

        assert PF_Ciudades.save() != null

        // test invalid parameters in update
        params.id = PF_Ciudades.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/PF_Ciudades/edit"
        assert model.PF_CiudadesInstance != null

        PF_Ciudades.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/PF_Ciudades/show/$PF_Ciudades.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        PF_Ciudades.clearErrors()

        populateValidParams(params)
        params.id = PF_Ciudades.id
        params.version = -1
        controller.update()

        assert view == "/PF_Ciudades/edit"
        assert model.PF_CiudadesInstance != null
        assert model.PF_CiudadesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/PF_Ciudades/list'

        response.reset()

        populateValidParams(params)
        def PF_Ciudades = new PF_Ciudades(params)

        assert PF_Ciudades.save() != null
        assert PF_Ciudades.count() == 1

        params.id = PF_Ciudades.id

        controller.delete()

        assert PF_Ciudades.count() == 0
        assert PF_Ciudades.get(PF_Ciudades.id) == null
        assert response.redirectedUrl == '/PF_Ciudades/list'
    }
}
