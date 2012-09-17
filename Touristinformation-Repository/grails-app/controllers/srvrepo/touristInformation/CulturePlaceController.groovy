package srvrepo.touristInformation

import srvrepo.touristInformation.PlaceHelper
import groovyx.net.http.*
import grails.converters.JSON
import srvrepo.touristInformationModel.CulturePlace
import srvrepo.Service

class CulturePlaceController {

	def index() {
		render(text: "CulturePlace index")
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
			def kind = params.culturePlaceType
			if((myLatitude != null) && (myLongitude != null) && (range != null) && (kind != null)){
				//build new url
				String uRL = "$service.url?myLat=$myLatitude&myLng=$myLongitude&radius=$range&kind=$kind"
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
			def kind = params.culturePlaceType
			//build new url
			String uRL = "$service.url?myLat=$myLatitude&myLon=$myLongitude&radius=$range&kind=$kind"
			if((myLatitude != null) && (myLongitude != null) && (range != null) && (kind != null)){
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
			def kind = params.culturePlaceType
			//build new url
			String uRL = "$service.url?myLat=$myLatitude&myLon=$myLongitude&duration=$duration&kind=$kind"
			if((myLatitude != null) && (myLongitude != null) && (duration != null) && (kind != null)){
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

	def getEventsOfMuseum(){
		try{
			//find service
			def service = PlaceHelper.findService(params.serviceName)
			if(service == null){
				//Service unavailable
				render(text:PlaceHelper.getServerCode351JSON())
				return
			}
			//parse url
			def museumId = params.museumId
			//build new url
			String uRL = "$service.url?museumId=$museumId"
			if((museumId != null)){
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

