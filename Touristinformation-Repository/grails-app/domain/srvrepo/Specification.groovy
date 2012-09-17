package srvrepo

class Specification {
	
	def scaffold = true
	
	static belongsTo = [service : Service]
	
	String name

	String input
	String output
	String precondition
	String postcondition

	String description
	

	Specification(String tmpName){
		this.name = tmpName
	}
	

}
