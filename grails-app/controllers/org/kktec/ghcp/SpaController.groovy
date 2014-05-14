package org.kktec.ghcp

class SpaController {

    def scores() { 
		render view: 'scores/index', model: [scores: Score.list(), handicap: 'N/A']
	}
}
