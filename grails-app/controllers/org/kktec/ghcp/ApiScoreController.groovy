package org.kktec.ghcp

import grails.converters.JSON

import org.joda.time.LocalDate
import org.springframework.http.HttpStatus

class ApiScoreController {

	static allowedMethods = [save: 'POST', update: 'POST', delete: 'POST']
	
	def scoreService
	
	def handicapRecord() {
		Map handicapRecord = scoreService.handicapRecord()
		handicapRecord.scores = handicapRecord.scores*.toMap()
		render handicapRecord as JSON
	}
	
	def save() {
		Score score = new Score()
		saveScore score
	}
	
	def update(Long id) {
		Score score = scoreService.score id
		saveScore score
	}
	
	def delete(Long id) {
		Score score = scoreService.score id
		scoreService.delete score
		render status: HttpStatus.OK
	}
	
	private saveScore(Score score) {
		mapParamsToScore score
		score.validate()
		if (score.hasErrors()) {
			render status: HttpStatus.UNPROCESSABLE_ENTITY
			return
		}
		
		scoreService.save(score)
		render status: HttpStatus.OK
	}
	
	private mapParamsToScore(Score score) {
		try {
			score.playedOn = LocalDate.parse params.playedOn
		} catch (IllegalArgumentException x) {
			score.playedOn = new LocalDate(params.playedOn.toLong())
		}
		score.strokes = params.strokes.toInteger()
		score.rating = params.rating.toBigDecimal()
		score.slope = params.slope.toInteger()
	}
}
