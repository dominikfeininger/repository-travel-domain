package srvrepo.touristInformation

import groovyx.net.http.*
import grails.converters.JSON
import srvrepo.touristInformationModel.Cinema
import srvrepo.Service

class CinemaController {

	def index() {
		render(text:"cinema index")
	}

	def findInKmRange(){
		try{
			//find service
			def service = PlaceHelper.findService(params.serviceName)
			if(service == null){
				//Service unavailable
				render(text:PlaceHelper.getServerCode351JSON())
				return
			}
			//parse url
			def myLatitude = params.mylat
			def myLongitude = params.mylng
			def range = params.range
			def movieType = params.movieType
			if((myLatitude != null) && (myLongitude != null) && (range != null) && (movieType != null)){
				//build new url
				String uRL = "$service.url?myLat=$myLatitude&myLng=$myLongitude&radius=$range&movieType=$movieType"
				//System.out.println(uRL);
				//request
				def resp = PlaceHelper.makeHTTPRequestWithJson(uRL)
				//render result
				render(text:resp.toString())
			}else{
				//Parameter Error
				render(text: PlaceHelper.getServerCode361JSON())
				return
			}
		}catch (Exception){
			render(text:PlaceHelper.getServerCode371JSON())
		}
	}

	def findInMinRange(){
		try{
			//find service
			def service = PlaceHelper.findService(params.serviceName)
			if(service == null){
				//Service unavailable
				render(text:PlaceHelper.getServerCode351JSON())
				return
			}
			//parse url
			def myLatitude = params.mylat
			def myLongitude = params.mylon
			def range = params.range
			def movieType = params.movieType
			if((myLatitude != null) && (myLongitude != null) && (range != null) && (movieType != null)){
				//build new url
				String uRL = "$service.url?myLat=$myLatitude&myLon=$myLongitude&radius=$range&movieType=$movieType"
				//System.out.println(uRL);
				//request
				def resp = PlaceHelper.makeHTTPRequestWithJson(uRL)
				//render result
				//System.out.println(resp.data.toString())
				render(text:resp.toString())
			}else{
				//Parameter Error
				render(text: PlaceHelper.getServerCode361JSON())
				return
			}
		}catch (Exception){
			render(text:PlaceHelper.getServerCode371JSON())
		}
	}

	def findInDuration(){
		try{
			//find service
			def service = PlaceHelper.findService(params.serviceName)
			if(service == null){
				//Service unavailable
				render(text:PlaceHelper.getServerCode351JSON())
				return
			}
			//parse url
			def myLatitude = params.mylat
			def myLongitude = params.mylon
			def duration = params.duration
			def movieType = params.movieType
			//build new url
			String uRL = "$service.url?myLat=$myLatitude&myLon=$myLongitude&duration=$duration&movieType=$movieType"
			if((myLatitude != null) && (myLongitude != null) && (duration != null) && (movieType != null)){
				//System.out.println(uRL);
				//request
				def resp = PlaceHelper.makeHTTPRequestWithJson(uRL)
				//render result
				//System.out.println(resp.data.toString())
				render(text:resp.toString())
			}else{
				//Parameter Error
				render(text: PlaceHelper.getServerCode361JSON())
				return
			}
		}catch (Exception){
			render(text:PlaceHelper.getServerCode371JSON())
		}
	}

	def getMoviesForCinema(){
		try{
			//find service
			def service = PlaceHelper.findService(params.serviceName)
			if(service == null){
				//Service unavailable
				render(text:PlaceHelper.getServerCode351JSON())
				return
			}
			//parse url
			def cinemaId = params.cinemaId
			//build new url
			String uRL = "$service.url?cinemaId=$cinemaId"
			if((cinemaId != null)){
				//System.out.println(uRL);
				//request
				def resp = PlaceHelper.makeHTTPRequestWithXML(uRL)
				//render result
				//System.out.println(resp.data.toString())
				render(text:resp.toString())
			}else{
				//Parameter Error
				render(text: PlaceHelper.getServerCode361JSON())
				return
			}
		}catch (Exception){
			render(text:PlaceHelper.getServerCode371XML())
		}
	}
}

