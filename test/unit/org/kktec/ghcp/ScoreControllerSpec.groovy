package org.kktec.ghcp

import grails.test.mixin.TestFor

import org.joda.time.LocalDate

import spock.lang.Specification

@TestFor(ScoreController)
class ScoreControllerSpec extends Specification {
	
	ScoreService scoreService = Mock()
	
	static final Long ID = 13
	
	static final Integer STROKES = 75
	
	static final RATING = 70.2
	
	static final SLOPE = 125
	
	static final PLAYED_ON = new LocalDate() 
	
	static final SCORE = new Score(id: ID, strokes: STROKES, playedOn: PLAYED_ON)
	
	List scores = [SCORE]
	
	Map handicapRecord = [scores: scores, handicap: 9.8]

	def setup() {
		controller.scoreService = scoreService
	}
	
	def 'can render the handicap record'() {
		when:
		controller.index()
		
		then:
		1 * scoreService.handicapRecord() >> handicapRecord
		0 * _
		view == '/score/list'
		model.handicapRecord == handicapRecord
	}
	
	def 'can render a form to create a new Score'() {
		when:
		controller.create()
		
		then:
		0 * _
		view == '/score/create'
		model.score instanceof Score
	}
	
	def 'can save a valid new Score'() {
		given:
		initScoreParams()
		
		when:
		controller.save()
		
		then:
		1 * scoreService.save(_ as Score) >> { args -> assertScore args[0] }
		1 * scoreService.handicapRecord() >> handicapRecord
		0 * _
		view == '/score/list'
		model.handicapRecord == handicapRecord
		flash.message == "Saved new score: $STROKES played on $PLAYED_ON"
	}
	
	def 'can NOT save an invalid new Score'() {
		when:
		controller.save()
		
		then:
		1 * scoreService.save(_ as Score) >> null
		0 * _
		view == '/score/create'
		model.score instanceof Score
	}
	
	def 'can delete a Score'() {
		when:
		controller.delete ID
		
		then:
		1 * scoreService.score(ID) >> SCORE
		1 * scoreService.delete(SCORE)
		0 * _
		response.redirectedUrl == '/scores/index'
		flash.message == "Deleted score: $STROKES played on $PLAYED_ON"
	}
	
	def 'can NOT delete a Score that does not exist'() {
		when:
		controller.delete ID
		
		then:
		1 * scoreService.score(ID) >> null
		0 * _
		response.redirectedUrl == '/scores/index'
		flash.message == controller.SCORE_NOT_FOUND
	}
	
	def 'can edit an existing Score'() {
		when:
		controller.edit ID

		then:
		1 * scoreService.score(ID) >> SCORE
		0 * _
		view == '/score/edit'
		model.score == SCORE
	}
	
	def 'can NOT edit a Score that does not exist'() {
		when:
		controller.edit ID

		then:
		1 * scoreService.score(ID) >> null
		1 * scoreService.handicapRecord() >> handicapRecord
		0 * _
		view == '/score/list'
		model.handicapRecord == handicapRecord
		flash.message == controller.SCORE_NOT_FOUND		
	}
	
	def 'can update a Score'() {
		given:
		initScoreParams()
		
		when:
		controller.update(ID)
		
		then:
		1 * scoreService.score(ID) >> SCORE
		1 * scoreService.save(SCORE) >> { args -> assertScore args[0] }
		0 * _
		response.redirectedUrl == '/scores/index'
		flash.message == "Updated score: $STROKES played on $PLAYED_ON"
	}
	
	def 'can NOT update a Score that does not exist'() {
		when:
		controller.update(ID)
		
		then:
		1 * scoreService.score(ID) >> null
		1 * scoreService.handicapRecord() >> handicapRecord
		0 * _
		view == '/score/list'
		model.handicapRecord == handicapRecord
		flash.message == controller.SCORE_NOT_FOUND		
	}
	
	def 'can NOT update an invalid Score'() {
		when:
		controller.update(ID)
		
		then:
		1 * scoreService.score(ID) >> SCORE
		1 * scoreService.save(SCORE) >> null
		0 * _
		view == '/score/edit'
		model.score == SCORE
	}
	
	private initScoreParams() {
		params.strokes = STROKES
		params.rating = RATING
		params.slope = SLOPE
		params.playedOn = PLAYED_ON
	}
	
	private Score assertScore(Score score) {
		with(score) {
			strokes == STROKES
			rating == RATING
			slope == SLOPE
			playedOn == PLAYED_ON
		}
		score
	}
}
