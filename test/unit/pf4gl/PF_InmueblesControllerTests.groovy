package pf4gl



import org.junit.*
import grails.test.mixin.*

@TestFor(PF_InmueblesController)
@Mock(PF_Inmuebles)
class PF_InmueblesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/PF_Inmuebles/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.PF_InmueblesInstanceList.size() == 0
        assert model.PF_InmueblesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.PF_InmueblesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.PF_InmueblesInstance != null
        assert view == '/PF_Inmuebles/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/PF_Inmuebles/show/1'
        assert controller.flash.message != null
        assert PF_Inmuebles.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Inmuebles/list'

        populateValidParams(params)
        def PF_Inmuebles = new PF_Inmuebles(params)

        assert PF_Inmuebles.save() != null

        params.id = PF_Inmuebles.id

        def model = controller.show()

        assert model.PF_InmueblesInstance == PF_Inmuebles
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Inmuebles/list'

        populateValidParams(params)
        def PF_Inmuebles = new PF_Inmuebles(params)

        assert PF_Inmuebles.save() != null

        params.id = PF_Inmuebles.id

        def model = controller.edit()

        assert model.PF_InmueblesInstance == PF_Inmuebles
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Inmuebles/list'

        response.reset()

        populateValidParams(params)
        def PF_Inmuebles = new PF_Inmuebles(params)

        assert PF_Inmuebles.save() != null

        // test invalid parameters in update
        params.id = PF_Inmuebles.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/PF_Inmuebles/edit"
        assert model.PF_InmueblesInstance != null

        PF_Inmuebles.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/PF_Inmuebles/show/$PF_Inmuebles.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        PF_Inmuebles.clearErrors()

        populateValidParams(params)
        params.id = PF_Inmuebles.id
        params.version = -1
        controller.update()

        assert view == "/PF_Inmuebles/edit"
        assert model.PF_InmueblesInstance != null
        assert model.PF_InmueblesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/PF_Inmuebles/list'

        response.reset()

        populateValidParams(params)
        def PF_Inmuebles = new PF_Inmuebles(params)

        assert PF_Inmuebles.save() != null
        assert PF_Inmuebles.count() == 1

        params.id = PF_Inmuebles.id

        controller.delete()

        assert PF_Inmuebles.count() == 0
        assert PF_Inmuebles.get(PF_Inmuebles.id) == null
        assert response.redirectedUrl == '/PF_Inmuebles/list'
    }
}
