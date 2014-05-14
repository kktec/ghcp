package org.kktec.ghcp

import grails.test.mixin.TestFor

import org.joda.time.LocalDate

import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Score)
class ScoreSpec extends Specification {
	
	Score score = new Score()
	
	def setup() { mockForConstraintsTests(Score) }
	
	@Unroll
	def 'validation for strokes value #strokes yields error code #error'() {
		given:
		score.strokes = strokes
		
		when:
		score.validate()
		
		then:
		score.errors.strokes == error
		
		where:
		strokes || error
		null    || 'nullable'
		53      || 'min'
		54      || null
		72      || null
		199     || null
		200     || 'max'
	}
	
	@Unroll
	def 'validation for rating value #rating yields error code #error'() {
		given:
		score.rating = rating
		
		when:
		score.validate()
		
		then:
		score.errors.rating == error
		
		where:
		rating || error
		null   || 'nullable'
		59.9   || 'min'
		60.0   || null
		72.0   || null
		89.9   || null
		90.0   || 'max'
	}

	@Unroll
    def 'validation for slope value #slope yields error code #error'() {
		given:
		score.slope = slope
		
		when:
		score.validate()
		
		then:
		score.errors.slope == error
		
		where:
		slope || error
		null  || 'nullable'
		54    || 'min'
		55    || null
		113   || null
		175   || null
		176   || 'max'
    }
	
	def 'slope has a default value of 113'() { expect: new Score().slope == 113 }
	
	@Unroll
	def 'can calculate a handicap differential of #differential with strokes #strokes rating #rating slope #slope  '() {
		given:
		Score score = new Score(strokes: strokes, rating: rating, slope: slope)
		
		expect:
		score.differential == differential
		
		where:
		strokes | rating | slope   || differential
		72      | 72.0   | 101     || 0.0
		72      | 72.0   | 113     || 0.0
		72      | 72.0   | 144     || 0.0
		72      | 69.0   | 101     || 2.7
		72      | 69.0   | 113     || 3.0
		72      | 69.0   | 144     || 3.8
		72      | 75.0   | 101     || -2.7
		72      | 75.0   | 113     || -3.0
		72      | 75.0   | 144     || -3.8
		84		| 71.5	 | 113.452 || 12.5
	}
	
	def 'playedOn is required'() {
		given:
		score.playedOn = null
		
		when: 
		score.validate()
		
		then:
		score.errors.playedOn == 'nullable'
	}
	
	def 'playedOn defaults to today'() {
		expect: score.playedOn == new LocalDate()
	}
}
