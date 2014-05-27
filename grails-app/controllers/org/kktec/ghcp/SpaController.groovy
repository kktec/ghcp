package org.kktec.ghcp

import grails.converters.JSON

class SpaController {
	
    def index() { 
		render view: 'scores/plain', model: [scores: Score.list(), handicap: 'N/A']
	}
	
	def scores_js() {
		render view: 'scores/js'
	}
	
	def handicap() {
		render ([handicap: 'n/a']) as JSON
	}
	
}
