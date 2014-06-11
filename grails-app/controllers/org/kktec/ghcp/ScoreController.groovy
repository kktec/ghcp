package org.kktec.ghcp

class ScoreController {
	
	static allowedMethods = [save: 'POST', update: 'POST', delete: 'POST']
	
	def scoreService
	
    def index() {
		render view: 'list', model: [handicapRecord: scoreService.handicapRecord()]
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
		redirect action: 'index'
	}
	
	def edit(Long id) {
		Score score = scoreService.score id
		if (score) {
			render view: 'edit', model: [score: score]
			return
		}
		
		flash.message = 'The score could not be found'
		index()
	}
	
	def update(Long id) {
		Score score = scoreService.score id
		if (!score) {
			flash.message = 'The score could not be found'
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
