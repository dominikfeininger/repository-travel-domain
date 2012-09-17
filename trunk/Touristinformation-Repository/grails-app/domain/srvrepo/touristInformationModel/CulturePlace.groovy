package srvrepo.touristInformationModel

import srvrepo.touristInformationModel.types.CultureType

class CulturePlace{
	
	def scaffold = true
	
	GPSLocation location
	
	def String name;
	def String description;
	def File picture
	
	static hasMany = [events : Event]
	
	CultureType culturePlaceType

    static constraints = {
    }

}
