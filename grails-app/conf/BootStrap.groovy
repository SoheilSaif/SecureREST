import securerest.SecAppRole
import securerest.SecAppUser
import securerest.SecAppUserSecAppRole

class BootStrap {

	def init = { servletContext ->
		createUsersRoles()
	}

	def createUsersRoles() {

		def adminRole = new SecAppRole(authority: 'ROLE_ADMIN').save(flush: true)
		def apiRole = new SecAppRole(authority: 'ROLE_API').save(flush: true)

		def testUser = new SecAppUser(username: 'admin', enabled: true, password: 'admin')
		testUser.save(flush: true)


		def apiUser = new SecAppUser(username: 'api', enabled: true, password: 'api')
		apiUser.save(flush: true)

		SecAppUserSecAppRole.create testUser, adminRole, true
		SecAppUserSecAppRole.create apiUser, apiRole, true

		assert SecAppUser.count() == 2
		assert SecAppRole.count() == 2
		assert SecAppUserSecAppRole.count() == 2
	}

	def destroy = {
	}
}
