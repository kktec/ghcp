class UrlMappings {

	static mappings = {
		"/scores/$action?/$id?"(controller: 'simpleScore')
		"/api/scores"(resources: 'score')
		
        "/"(view: "/index")
        "500"(view: '/error')
	}
}
