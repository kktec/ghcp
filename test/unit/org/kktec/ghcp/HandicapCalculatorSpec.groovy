package org.kktec.ghcp

import org.joda.time.LocalDate

import spock.lang.Specification

class HandicapCalculatorSpec extends Specification {

	HandicapCalculator calculator = new HandicapCalculator()
	
	List fourScores = [
		new Score(playedOn: new LocalDate(2014, 5, 12), strokes: 83, rating: 70.2, slope: 117),
		new Score(playedOn: new LocalDate(2014, 5, 13), strokes: 83, rating: 70.2, slope: 117),
		new Score(playedOn: new LocalDate(2014, 5, 13), strokes: 88, rating: 70.2, slope: 117),
		new Score(playedOn: new LocalDate(2014, 5, 14), strokes: 81, rating: 70.2, slope: 117),
	]
	
	List elevenScores = [
		new Score(playedOn: new LocalDate(2014, 5, 15), strokes: 82, rating: 70.2, slope: 117),
		new Score(playedOn: new LocalDate(2014, 5, 16), strokes: 84, rating: 70.0, slope: 116),
		new Score(playedOn: new LocalDate(2014, 5, 17), strokes: 85, rating: 70.2, slope: 117),
		new Score(playedOn: new LocalDate(2014, 5, 18), strokes: 82, rating: 70.2, slope: 117),
		new Score(playedOn: new LocalDate(2014, 5, 18), strokes: 79, rating: 70.2, slope: 117),
		new Score(playedOn: new LocalDate(2014, 5, 19), strokes: 84, rating: 70.2, slope: 115),
		new Score(playedOn: new LocalDate(2014, 5, 20), strokes: 85, rating: 69.8, slope: 114),
		new Score(playedOn: new LocalDate(2014, 5, 21), strokes: 84, rating: 70.2, slope: 117),
		new Score(playedOn: new LocalDate(2014, 5, 22), strokes: 75, rating: 70.0, slope: 116),
		new Score(playedOn: new LocalDate(2014, 5, 23), strokes: 81, rating: 69.8, slope: 114),
		new Score(playedOn: new LocalDate(2014, 5, 24), strokes: 85, rating: 69.8, slope: 114),
	]
	
	List sixScores = [
		new Score(playedOn: new LocalDate(2014, 5, 25), strokes: 82, rating: 69.8, slope: 114),
		new Score(playedOn: new LocalDate(2014, 5, 26), strokes: 78, rating: 69.8, slope: 114),
		new Score(playedOn: new LocalDate(2014, 5, 27), strokes: 79, rating: 69.8, slope: 114),
		new Score(playedOn: new LocalDate(2014, 5, 28), strokes: 76, rating: 69.8, slope: 114),
		new Score(playedOn: new LocalDate(2014, 5, 29), strokes: 75, rating: 70.2, slope: 117),
		new Score(playedOn: new LocalDate(2014, 5, 29), strokes: 69, rating: 70.2, slope: 117),
	]
	
	
	def 'can NOT calculate a handicap if less than 5 scores'() {
		when:
		BigDecimal handicap = calculator.handicap fourScores
		List usedDifferentials = usedDifferentials fourScores
		
		then:
		handicap == null
		usedDifferentials == []
	}
	
	def 'can calculate a handicap with less than 16 scores'() {
		given: 
		List scores = fourScores + elevenScores
		
		when:
		BigDecimal handicap = calculator.handicap scores
		List usedDifferentials = usedDifferentials scores
		
		then:
		handicap == 10.5
		usedDifferentials == [12.4, 12.4, 10.4, 11.4, 13.6, 11.4, 8.5, 13.3, 4.9, 11.1]
	}

	def 'can calculate a handicap with 16 scores'() {
		given: 
		List scores = fourScores + elevenScores + sixScores[0]
		
		when:
		BigDecimal handicap = calculator.handicap scores
		List usedDifferentials = usedDifferentials scores
		
		then:
		handicap == 10.4
		usedDifferentials == [12.4, 12.4, 10.4, 11.4, 11.4, 8.5, 13.3, 4.9, 11.1, 12.1]
	}

	def 'can calculate a handicap using only the 20 most recent scores'() {
		given:
		List scores = fourScores + elevenScores + sixScores
		
		when:
		BigDecimal handicap = calculator.handicap scores
		List usedDifferentials = usedDifferentials scores
		
		then:
		handicap == 8.2
		usedDifferentials == [10.4, 11.4, 11.4, 8.5, 4.9, 11.1, 8.1, 9.1, 6.1, 4.6]
	}
	
	private List usedDifferentials(List scores) {
		scores.findAll { it.used }*.differential
	}
}
