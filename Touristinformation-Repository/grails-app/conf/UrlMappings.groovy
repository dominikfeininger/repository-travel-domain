class UrlMappings {

	static mappings = {
		"/gui/$controller/$action?/$id?" { }
		
		//general mobile app
		"/$controller/$action?/$id?" { }
		"/$controller/$action" { }

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
