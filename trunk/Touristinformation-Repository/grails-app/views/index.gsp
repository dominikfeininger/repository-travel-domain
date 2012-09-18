

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <title>Service Repository</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
        </div>
        <div class="body" style="margin-left:50px">
            <h1><g:message code="default.available-functions.label" default="Available Functions" /></h1>
			<ul>
				<li><g:link controller="vendor" action="list">vendors</g:link></li>
				<li><g:link controller="specification" action="list">specifications</g:link></li>
				<li><g:link controller="service" action="list">services</g:link></li>
			</ul>
		</div>
	</body>
</html>