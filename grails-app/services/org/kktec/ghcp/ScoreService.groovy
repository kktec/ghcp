package org.kktec.ghcp

class ScoreService {
	
	static final String LIST_QUERY = 'from Score as s order by s.playedOn desc, s.id desc'
	
	final HandicapCalculator calculator = new HandicapCalculator()
	
	Score score(Long id) {
		Score.get id
	}
	
	/**
	 * Fetches the handicap record. 
	 * 
	 * @return Map containing a List of scores (most recent first) and the calculated handicap
	 */
	Map handicapRecord() {
		List scores = Score.findAll(LIST_QUERY)
		[scores: scores, handicap: calculator.handicap(scores)]
	}
	
	Score save(Score score) {
		score.save(flush: true)
	}
	
	void delete(Score score) {
		score.delete(flush: true)
	}
}
