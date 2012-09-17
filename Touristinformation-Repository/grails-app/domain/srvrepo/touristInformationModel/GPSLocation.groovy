package srvrepo.touristInformationModel

class GPSLocation {
	
	def scaffold = true
	
	def float latitude
	def float longitude
	
	def String streetName
	def String houseNumber
	def String zip
	def String city
	def String state

    static constraints = {
    }
	
}
