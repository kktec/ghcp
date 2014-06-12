package org.kktec.ghcp

import grails.test.spock.IntegrationSpec
import spock.lang.Shared

class ScoreServiceIntegrationSpec extends IntegrationSpec {

	@Shared
	ScoreService scoreService
	
	def 'can get the handicap record with most recent scores first'() {
		when:
		Map handicapRecord = scoreService.handicapRecord()
		
		then:
		handicapRecord.scores.size() == 20
		handicapRecord.handicap == 8.2
		handicapRecord.scores[18].playedOn > handicapRecord.scores[19].playedOn
		handicapRecord.scores[17].playedOn == handicapRecord.scores[18].playedOn
		handicapRecord.scores[18].id > handicapRecord.scores[19].id
	}
	
	def 'can fetch and delete a Score'() {
		expect:
		Score score = scoreService.score 10

		when:
		scoreService.delete score
		score = scoreService.score 10
		Map handicapRecord = scoreService.handicapRecord()
		
		then:
		score == null
		handicapRecord.scores.size() == 19
		handicapRecord.handicap == 7.9
	}

	def 'can fetch and change a Score'() {
		given:
		Score score = scoreService.score 10
		
		when:
		score.strokes = 69
		scoreService.save score
		score = scoreService.score 10
		Map handicapRecord = scoreService.handicapRecord()
		
		then:
		score.strokes == 69
		handicapRecord.scores.size() == 20
		handicapRecord.handicap == 7.0
	}

}
