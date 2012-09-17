package srvrepo.touristInformationModel

class Cinema{
	
	def scaffold = true
	
	GPSLocation location
	
	def String name;
	def String description;
	def File picture
	
	static hasMany = [movies : Movie]

    static constraints = {
		
    }
}
