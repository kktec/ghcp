package org.kktec.ghcp

import java.math.RoundingMode

import org.joda.time.LocalDate

class Score {
	
	static Integer DEFAULT_SLOPE = 113
	
	Integer strokes
	
	BigDecimal rating
	
	Integer slope = DEFAULT_SLOPE
	
	LocalDate playedOn = new LocalDate()
	
	BigDecimal getDifferential() {
		BigDecimal differential = (strokes - rating) * slope / DEFAULT_SLOPE
		differential.setScale 1, RoundingMode.HALF_DOWN
	}

    static constraints = {
		strokes(min: 54, max: 199)
		rating(min: 60.0, max: 89.9)
		slope(min: 55, max: 175)
    }
}
