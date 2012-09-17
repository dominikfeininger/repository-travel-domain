package srvrepo.touristInformation

import groovyx.net.http.*
import srvrepo.touristInformation.PlaceHelper
import grails.converters.JSON
import srvrepo.touristInformationModel.Restaurant
import srvrepo.Service

class RestaurantController {

	def index() {
		render (text:"restaurant index")
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
			//System.out.println("range: " + range);
			def cuisine = params.cuisine
			if((myLatitude != null) && (myLongitude != null) && (range != null) && (cuisine != null)){
				//System.out.println("range: " + range);
				//build new url
				String uRL = "$service.url?myLat=$myLatitude&myLng=$myLongitude&radius=$range&cuisine=$cuisine"
				System.out.println(uRL);
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
			//System.out.println("exception" + Exception);
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
			def cuisine = params.cuisine
			if((myLatitude != null) && (myLongitude != null) && (range != null) && (cuisine != null)){
				//build new url
				String uRL = "$service.url?myLat=$myLatitude&myLon=$myLongitude&radius=$range&cuisine=$cuisine"
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
			def cuisine = params.cuisine
			if((myLatitude != null) && (myLongitude != null) && (duration != null) && (cuisine != null)){
				//build new url
				String uRL = "$service.url?myLat=$myLatitude&myLon=$myLongitude&radius=$range&cuisine=$cuisine"
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
