package org.kktec.ghcp

import groovy.transform.ToString

import java.math.RoundingMode

import org.joda.time.LocalDate

@ToString
class Score {
	
	static final Integer DEFAULT_SLOPE = 113
	
	Integer strokes
	
	BigDecimal rating
	
	Integer slope = DEFAULT_SLOPE
	
	LocalDate playedOn = new LocalDate()
	
	transient boolean used
	
	BigDecimal getDifferential() {
		BigDecimal differential = (strokes - rating) * DEFAULT_SLOPE / slope
		differential.setScale 1, RoundingMode.HALF_DOWN
	}
	
	Map toMap() {
		[id: id, strokes: strokes, rating: rating, slope: slope, playedOn: playedOn, differential: differential, used: used]
	}

    static constraints = {
		strokes(min: 54, max: 199)
		rating(scale: 1, min: 60.0, max: 89.9)
		slope(min: 55, max: 199)
		playedOn(max: new LocalDate())
    }
}
