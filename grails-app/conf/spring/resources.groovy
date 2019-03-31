import medwing.be.provider.GoogleGeoService

// Place your Spring DSL code here
beans = {
    geocodeProvider(GoogleGeoService){
        grailsApplication = ref('grailsApplication')
    }
}
