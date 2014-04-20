package wdwk

import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured
import org.codehaus.groovy.grails.commons.GrailsClassUtils

class AskController {

  def springSecurityService

  @Secured(['ROLE_USER', 'IS_AUTHENTICATED_FULLY'])
  def index() { 
    log.debug("Index()");
  }
}
