package medwing.be.provider

import grails.core.GrailsApplication
import groovyx.net.http.RESTClient
import medwing.be.Marker

import javax.annotation.PostConstruct

class GoogleGeoService implements IGeoProvider {

    String host
    String context
    String apiKey

    GrailsApplication grailsApplication

    @PostConstruct
    init() {
        host = grailsApplication.config.getProperty("medwing.google.geocode.host")
        context = grailsApplication.config.getProperty("medwing.google.geocode.context")
        apiKey = grailsApplication.config.getProperty("medwing.google.geocode.apiKey")
    }

    @Override
    List<Marker> getGeocode(String address) {
        List<Marker> markers = new ArrayList<>()
        try {
            RESTClient client = new RESTClient(host)
            def res = client.get(path: context, query: [address: address, key: apiKey], headers: [:]).data.results

            res.each {
                markers.add(new Marker(
                        id: it.place_id,
                        name: it.formatted_address,
                        address: it.formatted_address,
                        lat: it.geometry.location.lat,
                        lng: it.geometry.location.lng))
            }
        } catch (Exception e) {
            throw e
        }
        return markers
    }
}
