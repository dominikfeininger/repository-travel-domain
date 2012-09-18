
<%@ page import="srvrepo.Service"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<g:set var="entityName"
	value="${message(code: 'service.label', default: 'Service')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<div class="nav">
		<span class="menuButton"><a class="home"
			href="${createLink(uri: '/')}"><g:message
					code="default.home.label" /></a></span> <span class="menuButton"><g:link
				class="create" action="create">
				<g:message code="default.new.label" args="[entityName]" />
			</g:link></span>

	</div>
	<div class="body" style="margin-left:50px">
		<h1>
			<g:message code="default.list.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message">
				${flash.message}
			</div>
		</g:if>
		<div class="list">
			<table>
				<thead>
					<tr>

						<g:sortableColumn property="id"
							title="${message(code: 'service.id.label', default: 'Id')}" />

						<g:sortableColumn property="name"
							title="${message(code: 'service.name.label', default: 'Name')}" />

						<th><g:message code="service.vendor.label" default="Vendor" /></th>
					</tr>
				</thead>
				<tbody>
					<g:each in="${serviceInstanceList}" status="i"
						var="serviceInstance">
						<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

							<td><g:link action="show" id="${serviceInstance.id}">
									${fieldValue(bean: serviceInstance, field: "id")}
								</g:link></td>

							<td>
								${fieldValue(bean: serviceInstance, field: "name")}
							</td>

							<td><g:link controller="vendor" action="show"
									id="${serviceInstance.vendor.id}">
									${fieldValue(bean: serviceInstance.vendor, field: "name")}
								</g:link></td>

						</tr>
					</g:each>
				</tbody>
			</table>
		</div>
		<div class="paginateButtons">
			<g:paginate total="${serviceInstanceTotal}" />
		</div>
	</div>
</body>
</html>
