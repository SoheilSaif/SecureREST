import com.odobo.grails.plugin.springsecurity.rest.token.storage.GormTokenStorageService

// Place your Spring DSL code here
beans = {
	//use local GormTokenStorageService
	//as we need to manage token expiry
	tokenStorageService(securerest.GormTokenStorageService) {
		userDetailsService = ref('userDetailsService')
	}
}



