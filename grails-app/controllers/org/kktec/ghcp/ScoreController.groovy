package org.kktec.ghcp

import grails.rest.RestfulController

class ScoreController extends RestfulController {

	static responseFormats = ['json']
	
	ScoreController() { super(Score) }
	
}
