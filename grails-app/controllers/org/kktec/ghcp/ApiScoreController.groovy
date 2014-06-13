package org.kktec.ghcp

import grails.converters.JSON

class ApiScoreController {

	static allowedMethods = [save: 'POST', update: 'PUT', delete: 'DELETE']
	
	def scoreService
	
	def handicapRecord() {
		Map handicapRecord = scoreService.handicapRecord()
		handicapRecord.scores = handicapRecord.scores*.toMap()
		render handicapRecord as JSON
	}
	

}
