## Setup

### Grails

Import this [grails](https://grails.org/download.html) project with gradle.

### Database
Using mongodb database adapter, which can connect to 
Mongo DB or Azure Cosmos DB dynamically, based on 
given configuration

To setup locally install [Mongo DB](https://www.mongodb.com/download-center)

Make sure MongoDB is running on 27017 port, if it's different we can configure in `application.yml`


## Fire it

With IDE configuration or run following command in project directory `./gradlew bootrun`

##  Geocode service provider 

Geocode provider can be configured dynamically, just inject target service provider as a bean in `resouces.groovy`
