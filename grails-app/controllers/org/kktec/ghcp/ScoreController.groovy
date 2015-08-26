package org.kktec.ghcp

class ScoreController {
	
	static allowedMethods = [save: 'POST', update: 'POST', delete: 'POST']
	
	static final String SCORE_NOT_FOUND = 'The score could not be found'
	
	def scoreService
	
	def ko() {
		render view: 'ko', model: [view: 'ko']
	}
	
	def kobs() {
		render view: 'kobs', model: [view: 'kobs']
	}
	
    def index() {
		render view: 'list', model: [view: 'plain', handicapRecord: scoreService.handicapRecord()]
	}
	
	def create() {
		render view: 'create', model: [score: new Score()]
	}
	
	def save() {
		Score score = new Score(params)
		if (!scoreService.save(score)) {
			render view: 'create', model: [score: score]
			return
		}
		
		flash.message = "Saved new score: $score.strokes played on $score.playedOn"
		index()
	}
	
	def delete(Long id) {
		Score score = scoreService.score id
		if (score) {
			scoreService.delete(score)
			flash.message = "Deleted score: $score.strokes played on $score.playedOn"
		} 
		else {
			flash.message = SCORE_NOT_FOUND
		}
		redirect action: 'index'
	}
	
	def edit(Long id) {
		Score score = scoreService.score id
		if (score) {
			render view: 'edit', model: [score: score]
			return
		}
		
		flash.message = SCORE_NOT_FOUND
		index()
	}
	
	def update(Long id) {
		Score score = scoreService.score id
		if (!score) {
			flash.message = SCORE_NOT_FOUND
			index()
			return
		}
		
		score.properties = params
		if (!scoreService.save(score)) {
			render view: 'edit', model: [score: score]
			return
		}
		
		flash.message = "Updated score: $score.strokes played on $score.playedOn"
		redirect action: 'index'
	}
 	
}
