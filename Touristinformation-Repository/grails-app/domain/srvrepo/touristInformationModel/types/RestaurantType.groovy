package srvrepo.touristInformationModel.types

public enum RestaurantType {
	MEXICAN('Mexican'),INDIAN('Indian'),CANADIAN('Canadian'), CHINESE('Chinese')
	
	String name

	RestaurantType(String name) {
	  this.name = name
	}
	
	String toString() { name }
}