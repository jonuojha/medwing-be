package medwing.be

import grails.converters.JSON
import org.springframework.http.HttpStatus

class MarkersController {

    def getAll() {
        try {
            render Marker.findAll() as JSON
        } catch (Exception e) {
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value()
            render([message: 'Failed to get markers', error: e.message] as JSON)
        }
    }

    def save() {
        try {
            Marker mark = new Marker(request.JSON)
            render mark.save(flush: true) as JSON
        } catch (Exception e) {
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value()
            render([message: 'Failed to save marker', error: e.message] as JSON)
        }
    }

    def update() {
        Marker marker = Marker.findById(params.id as String)
        if (!marker) {
            response.status = HttpStatus.NOT_FOUND.value()
            render([message: 'Marker not found'])
            return
        }
        try {
            marker.name = request.JSON.newName
            marker.save()
        } catch (Exception e) {
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value()
            render([message: 'Failed to update marker', error: e.message] as JSON)
        }
        render([message: "Updated marker"] as JSON)
    }

    def delete() {
        Marker marker = Marker.findById(params.id as String)
        if (!marker) {
            response.status = HttpStatus.NOT_FOUND.value()
            render([message: 'Marker not found'])
        }
        try {
            marker.delete()
        } catch (Exception e) {
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value()
            render([message: 'Failed to delete marker', error: e.message] as JSON)
        }
        render([message: "Deleted marker"] as JSON)
    }
}
