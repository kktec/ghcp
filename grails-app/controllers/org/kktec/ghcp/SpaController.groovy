package org.kktec.ghcp

import grails.converters.JSON

class SpaController {
	
    def index() { 
		render view: 'scores/plain', model: [scores: Score.list(), handicap: 'n/a']
	}
	
	def scores_js() {
		render view: 'scores/js'
	}
	
	def handicap() {
		Map hcp = [handicap: 'n/a']
		render hcp as JSON
	}
	
}
