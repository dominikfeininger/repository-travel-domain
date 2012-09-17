package srvrepo.touristInformationModel

import srvrepo.touristInformationModel.types.RestaurantType;

class Restaurant{
	
	def scaffold = true
	
	GPSLocation location
	
	def String name;
	def String description;
	def File picture
	
	RestaurantType restaurantType 

    static constraints = {
		
    }
	
	Restaurant(){
		
	}
	
	Restaurant(String tmpNme, String tmpDescription){
		this.name = tmpNme
		this.description = tmpDescription
	}
	
}



