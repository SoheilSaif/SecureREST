package securerest

import grails.plugin.springsecurity.annotation.Secured

class SecuredEndpointController {

	@Secured(['ROLE_API'])
	def index() {
		render "Secured Controller index page, for API_USER, PARAM=${params.id}"
	}

}