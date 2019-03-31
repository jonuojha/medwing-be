package medwing.be

import grails.converters.JSON
import medwing.be.provider.IGeoProvider

class GeocodeController {

    IGeoProvider geocodeProvider

    def index() {
        render(geocodeProvider.getGeocode(params.address as String) as JSON)
    }
}
