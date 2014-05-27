class UrlMappings {

	static mappings = {
		"/scores/$action?/$id?(.$format)?"(controller: 'spa')
		"/api/scores"(resources: 'score')
		
        "/"(view: "/index")
        "500"(view: '/error')
	}
}
