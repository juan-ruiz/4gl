package pf4gl



import org.junit.*
import grails.test.mixin.*

@TestFor(PF_MultimediaController)
@Mock(PF_Multimedia)
class PF_MultimediaControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/PF_Multimedia/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.PF_MultimediaInstanceList.size() == 0
        assert model.PF_MultimediaInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.PF_MultimediaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.PF_MultimediaInstance != null
        assert view == '/PF_Multimedia/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/PF_Multimedia/show/1'
        assert controller.flash.message != null
        assert PF_Multimedia.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Multimedia/list'

        populateValidParams(params)
        def PF_Multimedia = new PF_Multimedia(params)

        assert PF_Multimedia.save() != null

        params.id = PF_Multimedia.id

        def model = controller.show()

        assert model.PF_MultimediaInstance == PF_Multimedia
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Multimedia/list'

        populateValidParams(params)
        def PF_Multimedia = new PF_Multimedia(params)

        assert PF_Multimedia.save() != null

        params.id = PF_Multimedia.id

        def model = controller.edit()

        assert model.PF_MultimediaInstance == PF_Multimedia
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/PF_Multimedia/list'

        response.reset()

        populateValidParams(params)
        def PF_Multimedia = new PF_Multimedia(params)

        assert PF_Multimedia.save() != null

        // test invalid parameters in update
        params.id = PF_Multimedia.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/PF_Multimedia/edit"
        assert model.PF_MultimediaInstance != null

        PF_Multimedia.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/PF_Multimedia/show/$PF_Multimedia.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        PF_Multimedia.clearErrors()

        populateValidParams(params)
        params.id = PF_Multimedia.id
        params.version = -1
        controller.update()

        assert view == "/PF_Multimedia/edit"
        assert model.PF_MultimediaInstance != null
        assert model.PF_MultimediaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/PF_Multimedia/list'

        response.reset()

        populateValidParams(params)
        def PF_Multimedia = new PF_Multimedia(params)

        assert PF_Multimedia.save() != null
        assert PF_Multimedia.count() == 1

        params.id = PF_Multimedia.id

        controller.delete()

        assert PF_Multimedia.count() == 0
        assert PF_Multimedia.get(PF_Multimedia.id) == null
        assert response.redirectedUrl == '/PF_Multimedia/list'
    }
}
