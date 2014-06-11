package org.kktec.ghcp

import java.math.RoundingMode

class ScoreService {
	
	static final String LIST_QUERY = 'from Score as s order by s.playedOn desc, s.id desc'
	
	Score score(Long id) {
		Score.get id
	}
	
	Map handicapRecord() {
		List scores = Score.findAll(LIST_QUERY)
		List sortedScores = scores.collect { it }.sort { it.differential }
		int numberOfScores = scores.size()
		
		BigDecimal handicap = null
		if (numberOfScores < 5) { return [scores: scores, handicap: null] }
		
		Integer numberOfScoresToConsider = 10
		if (numberOfScores < 20) {
			if (numberOfScores <= 16) { (numberOfScores - 5) / 2 + 1 }
			else { numberOfScoresToConsider = numberOfScores - 10 }
		}
		
		List scoresToConsider = sortedScores.take numberOfScoresToConsider
		scoresToConsider.each { it.used = true }
		handicap = (scoresToConsider.sum { it.differential } / numberOfScoresToConsider * 0.96)
		[scores: scores, handicap: handicap.setScale(1, RoundingMode.HALF_DOWN)]
	}
	
	Score save(Score score) {
		score.save(flush: true)
	}
	
	void delete(Score score) {
		score.delete(flush: true)
	}
	


}
