package srvrepo

import srvrepo.Service

class Specification {
	
	def scaffold = true
	
	static belongsTo = [service : Service]
	
	String name
	String input
	String output
	String precondition
	String postcondition

	String description
	
	static constraints = {
		name(unique: true)
	}
	

}
