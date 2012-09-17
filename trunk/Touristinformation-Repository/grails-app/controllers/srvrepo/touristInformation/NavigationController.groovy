package srvrepo.touristInformation

import srvrepo.touristInformation.PlaceHelper
import grails.converters.JSON
import srvrepo.touristInformationModel.Restaurant
import srvrepo.Service

class NavigationController {

	def index = {  render(text: "navigation index")  }

	def getRoute = {
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
			def destLatitude = params.destlat
			def destLongitude = params.destlng
			if((myLatitude != null) && (myLongitude != null) && (destLatitude != null) && (destLongitude != null)){
				//build new url
				String uRL = "$service.url?mylat=$myLatitude&mylng=$myLongitude&destlat=$destLatitude&destlng=$destLongitude"
				//System.out.println(uRL);
				//request
				def resp = PlaceHelper.makeHTTPRequestWithJson(uRL)
				//render result
				System.out.println(resp)
				System.out.println(resp.toString())
				render(text:resp.toString())
			}else{
				//Parameter Error
				render(text: PlaceHelper.getServerCode361JSON())
				return
			}
		}catch (Exception){
			System.out.println("exception" + Exception);
			render(text:PlaceHelper.getServerCode371JSON())
		}
	}
}
