package medwing.be

import grails.converters.JSON
import medwing.be.provider.IGeoProvider
import org.springframework.http.HttpStatus

class GeocodeController {

    IGeoProvider geocodeProvider

    def index() {
        try {
            List<Marker> markers = geocodeProvider.getGeocode(params.address as String)
            render(markers as JSON)
        } catch (Exception e) {
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value()
            render([message: 'Failed to get geocodes', error: e.message] as JSON)
        }

    }
}
