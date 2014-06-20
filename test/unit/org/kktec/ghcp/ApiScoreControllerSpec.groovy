package org.kktec.ghcp

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import groovy.json.JsonSlurper

import org.joda.time.LocalDate
import org.springframework.http.HttpStatus

import spock.lang.Specification

@TestFor(ApiScoreController)
@Mock(Score)
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
	
	private initParams() {
		params.with {
			playedOn = PLAYED_ON.toString()
			strokes = STROKES.toString()
			rating = RATING.toString()
			slope = SLOPE.toString()
		}
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
		response.status == HttpStatus.OK.value
	}
	
	def 'can save a valid new Score'() {
		given:
		initParams()
		
		when:
		controller.save()
		
		then:
		1 * scoreService.save(_ as Score) >> SCORE
		0 * _
	}
	
	def 'can NOT save an invalid new Score'() {
		given:
		initParams()
		controller.params.strokes = '0'
		
		when:
		controller.save()
		
		then:
		0 * _
		response.status == HttpStatus.UNPROCESSABLE_ENTITY.value
	}
	
	def 'can update a valid Score'() {
		given:
		initParams()
		params.id = ID.toString()
		
		when:
		controller.update()
		
		then:
		1 * scoreService.score(ID) >> SCORE
		1 * scoreService.save(_ as Score)
		0 * _
	}
	
	def 'can NOT update an invalid Score'() {
		given:
		initParams()
		params.id = ID.toString()
		params.strokes = '0'
		
		when:
		controller.update()
		
		then:
		1 * scoreService.score(ID) >> SCORE
		0 * _
		response.status == HttpStatus.UNPROCESSABLE_ENTITY.value
	}
	
	def 'can delete a Score'() {
		given:
		params.id = ID.toString()
		
		when:
		controller.delete()
		
		then:
		1 * scoreService.score(ID) >> SCORE
		1 * scoreService.delete(SCORE)
		0 * _
		response.status == HttpStatus.OK.value
	}
	
}
