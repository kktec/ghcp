package org.kktec.ghcp

import grails.test.mixin.TestFor
import groovy.json.JsonSlurper

import org.joda.time.LocalDate

import spock.lang.Specification

@TestFor(ApiScoreController)
class ApiScoreControllerSpec extends Specification {

	ScoreService scoreService = Mock()
	
	static final Long ID = 13
	
	static final Integer STROKES = 75
	
	static final RATING = 70.2
	
	static final SLOPE = 125
	
	static final PLAYED_ON = new LocalDate() 
	
	static final SCORE = new Score(id: ID, strokes: STROKES, rating: RATING, slope: SLOPE, playedOn: PLAYED_ON)
	
	List scores = [SCORE]
	
	Map handicapRecord = [scores: scores, handicap: 9.8]

	def setup() {
		controller.scoreService = scoreService
	}
	
	def 'can render the handicap record'() {
		when:
		controller.handicapRecord()
		JsonSlurper js = new JsonSlurper()
		def parsedJson = js.parseText(response.text)
		
		
		then:
		1 * scoreService.handicapRecord() >> handicapRecord
		0 * _
		handicapRecord == parsedJson
	}
	
}
