package srvrepo.touristInformationModel.types

public enum MovieType {
	HORROR('Horror'),ACTION('Action'),LOVESTORY('Love Story'), DRAMA('Drama'), SCIFI('Scifi')
	
	String name

	MovieType(String name) {
	  this.name = name
	}
	
	String toString() { name }
}