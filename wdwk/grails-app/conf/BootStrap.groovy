import org.opendatasheffield.wdwk.*;

class BootStrap {

    def init = { servletContext ->

      log.debug("Init");

      // Global System Roles
      def contributorRole = WdwkRole.findByAuthority('ROLE_CONTRIBUTOR') ?: new WdwkRole(authority: 'ROLE_CONTRIBUTOR', roleType:'global').save(failOnError: true)
      def userRole = WdwkRole.findByAuthority('ROLE_USER') ?: new WdwkRole(authority: 'ROLE_USER', roleType:'global').save(failOnError: true)
      def editorRole = WdwkRole.findByAuthority('ROLE_EDITOR') ?: new WdwkRole(authority: 'ROLE_EDITOR', roleType:'global').save(failOnError: true)
      def adminRole = WdwkRole.findByAuthority('ROLE_ADMIN') ?: new WdwkRole(authority: 'ROLE_ADMIN', roleType:'global').save(failOnError: true)

      log.debug("Create admin user...");
      def adminUser = WdwkUser.findByUsername('admin')
      if ( ! adminUser ) {
        log.error("No admin user found, create");
        adminUser = new WdwkUser(
            username: 'admin',
            password: 'admin',
            display: 'Admin',
            email: 'admin@localhost',
            enabled: true).save(failOnError: true)
      }

      if (!adminUser.authorities.contains(adminRole)) {
        WdwkUserWdwkRole.create adminUser, adminRole
      }

      if (!adminUser.authorities.contains(userRole)) {
        WdwkUserWdwkRole.create adminUser, userRole
      }


    }

    def destroy = {
    }
}
