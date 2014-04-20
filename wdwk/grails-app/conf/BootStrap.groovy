import me.ianibbo.common.*

class BootStrap {

    def init = { servletContext ->

      log.debug("Init");

      // Global System Roles
      def contributorRole = AuthCommonRole.findByAuthority('ROLE_CONTRIBUTOR') ?: new AuthCommonRole(authority: 'ROLE_CONTRIBUTOR', roleType:'global').save(failOnError: true)
      def userRole = AuthCommonRole.findByAuthority('ROLE_USER') ?: new AuthCommonRole(authority: 'ROLE_USER', roleType:'global').save(failOnError: true)
      def editorRole = AuthCommonRole.findByAuthority('ROLE_EDITOR') ?: new AuthCommonRole(authority: 'ROLE_EDITOR', roleType:'global').save(failOnError: true)
      def adminRole = AuthCommonRole.findByAuthority('ROLE_ADMIN') ?: new AuthCommonRole(authority: 'ROLE_ADMIN', roleType:'global').save(failOnError: true)

      log.debug("Create admin user...");
      def adminUser = AuthCommonUser.findByUsername('admin')
      if ( ! adminUser ) {
        log.error("No admin user found, create");
        adminUser = new AuthCommonUser(
            username: 'admin',
            password: 'admin',
            display: 'Admin',
            email: 'admin@localhost',
            enabled: true).save(failOnError: true)
      }

      if (!adminUser.authorities.contains(adminRole)) {
        AuthCommonUserAuthCommonRole.create adminUser, adminRole
      }

      if (!adminUser.authorities.contains(userRole)) {
        AuthCommonUserAuthCommonRole.create adminUser, userRole
      }


    }

    def destroy = {
    }
}
