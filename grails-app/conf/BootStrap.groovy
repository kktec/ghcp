import grails.util.Environment

import org.joda.time.LocalDate
import org.kktec.ghcp.Score

class BootStrap {

    def init = { servletContext ->
		if (Environment.current == Environment.DEVELOPMENT) {
			new Score(playedOn: new LocalDate(2014, 5, 12), strokes: 83, rating: 70.2, slope: 117).save()
			new Score(playedOn: new LocalDate(2014, 5, 13), strokes: 83, rating: 70.2, slope: 117).save()
			new Score(playedOn: new LocalDate(2014, 5, 13), strokes: 88, rating: 70.2, slope: 117).save()
			new Score(playedOn: new LocalDate(2014, 5, 14), strokes: 81, rating: 70.2, slope: 117).save()
			new Score(playedOn: new LocalDate(2014, 5, 15), strokes: 82, rating: 70.2, slope: 117).save()
			new Score(playedOn: new LocalDate(2014, 5, 16), strokes: 84, rating: 70.0, slope: 116).save()
			new Score(playedOn: new LocalDate(2014, 5, 17), strokes: 85, rating: 70.2, slope: 117).save()
			new Score(playedOn: new LocalDate(2014, 5, 18), strokes: 82, rating: 70.2, slope: 117).save()
			new Score(playedOn: new LocalDate(2014, 5, 18), strokes: 79, rating: 70.2, slope: 117).save()
			new Score(playedOn: new LocalDate(2014, 5, 19), strokes: 84, rating: 70.2, slope: 115).save()
			new Score(playedOn: new LocalDate(2014, 5, 20), strokes: 85, rating: 69.8, slope: 114).save()
			new Score(playedOn: new LocalDate(2014, 5, 21), strokes: 84, rating: 70.2, slope: 117).save()
			new Score(playedOn: new LocalDate(2014, 5, 22), strokes: 75, rating: 70.0, slope: 116).save()
			new Score(playedOn: new LocalDate(2014, 5, 23), strokes: 81, rating: 69.8, slope: 114).save()
			new Score(playedOn: new LocalDate(2014, 5, 24), strokes: 85, rating: 69.8, slope: 114).save()
			new Score(playedOn: new LocalDate(2014, 5, 25), strokes: 82, rating: 69.8, slope: 114).save()
			new Score(playedOn: new LocalDate(2014, 5, 26), strokes: 78, rating: 69.8, slope: 114).save()
			new Score(playedOn: new LocalDate(2014, 5, 27), strokes: 79, rating: 69.8, slope: 114).save()
			new Score(playedOn: new LocalDate(2014, 5, 28), strokes: 76, rating: 69.8, slope: 114).save()
			new Score(playedOn: new LocalDate(2014, 5, 29), strokes: 75, rating: 70.2, slope: 117).save()
		}
    }
	
    def destroy = {
    }
}
