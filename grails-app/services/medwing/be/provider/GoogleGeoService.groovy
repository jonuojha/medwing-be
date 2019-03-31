package medwing.be.provider

import grails.core.GrailsApplication
import groovyx.net.http.RESTClient

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
    def getGeocode(String address) {
        def res
        try {
            RESTClient client = new RESTClient(host)
            res = client.get(path: context, query: [address: address, key: apiKey], headers: [:]).data
        } catch (Exception e) {
            throw e
        }
        return res
    }
}
