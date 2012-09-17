package srvrepo.touristInformationModel

class Event {
	
	def scaffold = true
	
	def String name
	def String description
	def double startTime
	def int duration

    static constraints = {
    }
}
