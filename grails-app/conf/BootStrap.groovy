import org.kktec.ghcp.Score

class BootStrap {

    def init = { servletContext ->
		
		println new Score(strokes: 79, rating: 69.3).save()
    }
	
    def destroy = {
    }
}
