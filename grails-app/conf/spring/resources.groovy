import grails.rest.render.json.JsonRenderer

import org.kktec.ghcp.Score

// Place your Spring DSL code here
beans = {
	scoreRenderer(JsonRenderer, Score) {
		excludes = ['class', 'id']
	}
}
