package srvrepo.touristInformationModel

import java.util.Date
import srvrepo.touristInformationModel.types.MovieType

class Movie {
	
	def scaffold = true
	
	Cinema cinema
	
	def String name
	def String description
	def float duration
	def Date startTime
	MovieType movieType

    static constraints = {
    }
}
