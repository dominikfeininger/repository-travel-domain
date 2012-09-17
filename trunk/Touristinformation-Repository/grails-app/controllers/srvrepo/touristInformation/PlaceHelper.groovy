package srvrepo.touristInformation;

import groovyx.net.http.*
import srvrepo.touristInformation.PlaceHelper
import grails.converters.JSON
import srvrepo.touristInformationModel.Restaurant
import srvrepo.Service

public class PlaceHelper {

	public static String serverCode351JSON = "{\"server_code\":\"351\", \"message\":\"Failed, Service Unavailable !\"}"
	public static String serverCode361JSON = "{\"server_code\":\"361\", \"message\":\"Parameter Error !\"}"
	public static String serverCode371JSON = "{\"server_code\":\"371\", \"message\":\"Connection Error !\"}"

	public static String serverCode361XML = "<?xml version=\"1.0\"?><node><server_code>361</server_code><messgae>Parameter Error !</messgae></node>"
	public static String serverCode351XML = "<?xml version=\"1.0\"?><node><server_code>351</server_code><messgae>Failed, Service Unavailable !</messgae></node>"
	public static String serverCode371XML = "<?xml version=\"1.0\"?><node><server_code>371</server_code><messgae>Connection Error !</messgae></node>"

	static String getServerCode351XML(){
		return serverCode351XML
	}
	
	static String getServerCode361XML(){
		return serverCode361XML
	}

	static String getServerCode371XML(){
		return serverCode371XML
	}

	static String getServerCode371JSON(){
		return serverCode371JSON
	}

	static String getServerCode351JSON(){
		return serverCode351JSON
	}

	static String getServerCode361JSON(){
		return serverCode361JSON
	}

	static Service findService(String serviceName){

		def tmpService = Service.findByName(serviceName)
		if((tmpService != null) && (tmpService.activated == true)){
			System.out.println("tmpService.specifications.name" + tmpService.specifications.name);
			//System.out.println("not null!! " + tmpService.url);
			tmpService.calls ++
			tmpService.save(flush:true)
		}else{
			//System.out.println("NULL " + serviceName);
			if(tmpService.specifications.name != null){
				//go for another service
			}else{
				tmpService.name = null
			}
		}
		return tmpService
	}

	static String makeHTTPRequestWithJson(String uRL){
		//build HttpURLClient object
		def http = new HttpURLClient( )
		//request
		def resp = http.request(url: uRL)
		return resp.getData()//.toString()
	}

	static String makeHTTPRequestWithXML(String uRL){
		//build HttpURLClient object
		def http = new HttpURLClient( )
		//request
		def resp = http.request(url: uRL)
		//return it
		return resp.getData().toString()
	}
}
