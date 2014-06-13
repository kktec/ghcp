class UrlMappings {

	static mappings = {
		"/scores/$action?/$id?"(controller: 'score')
		
		"/api/scores/$action?/$id?"(controller: 'apiScore')
		
        "/"(view: "/index")
        "500"(view: '/error')
	}
}
