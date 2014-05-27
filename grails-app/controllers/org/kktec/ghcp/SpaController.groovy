package org.kktec.ghcp

class SpaController {

    def scores() { 
		render view: 'scores/plain', model: [scores: Score.list(), handicap: 'N/A']
	}
}
