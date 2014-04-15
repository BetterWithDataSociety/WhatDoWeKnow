package wdwk

import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured
import org.codehaus.groovy.grails.commons.GrailsClassUtils

class HomeController {

  def springSecurityService

  def index() { 
    log.debug("Index()");
  }
}
