class UrlMappings {

	static mappings = {
		"/scores"(controller: 'spa', action: 'scores')
		"/api/scores"(resources: 'score')
		
        "/"(view: "/index")
        "500"(view: '/error')
	}
}
