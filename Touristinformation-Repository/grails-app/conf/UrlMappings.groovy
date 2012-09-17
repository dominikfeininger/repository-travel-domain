class UrlMappings {

	static mappings = {
		"/gui/$controller/$action?/$id?" { }
		
		//general mobile app
		"/touristInformation/$controller/$action?/$id?" { }
		"/touristInformation/$controller/$action" { }

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
