package medwing.be

class UrlMappings {

    static mappings = {

        group "/api", {
            "/markers"(controller: "markers", action: [GET : 'getAll',
                                                       POST: "save"])
            "/markers/$id"(controller: "markers", action: [DELETE: 'delete',
                                                           PUT   : "update"])
        }

        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
