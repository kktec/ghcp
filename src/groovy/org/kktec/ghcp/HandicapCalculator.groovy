package org.kktec.ghcp

import java.math.RoundingMode

class HandicapCalculator {

	/**
	 * Calculates the handicap from a List of scores.
	 * Note: Scores that are used in the calculation will be marked as used.
	 * 
	 * @param scores
	 * 
	 * @return the calculated handicap
	 */
	BigDecimal handicap(List scores) {
		List sortedScores = scores.take(20).sort { it.differential }
		int numberOfScores = scores.size()
		
		if (numberOfScores < 5) { return null }
		
		Integer numberOfScoresToConsider = 10
		if (numberOfScores < 20) {
			if (numberOfScores <= 16) { (numberOfScores - 5) / 2 + 1 }
			else { numberOfScoresToConsider = numberOfScores - 10 }
		}
		
		List scoresToConsider = sortedScores.take numberOfScoresToConsider
		scoresToConsider.each { it.used = true }
		BigDecimal totalDifferentials = scoresToConsider.sum { it.differential } 
		BigDecimal handicap = (totalDifferentials / numberOfScoresToConsider * 0.96)
		handicap.setScale(1, RoundingMode.HALF_DOWN)
	}
 }
