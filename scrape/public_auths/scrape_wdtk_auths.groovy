@Grapes([
    @Grab(group='net.sourceforge.nekohtml', module='nekohtml', version='1.9.14'),
    @Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.5.1'),
    @Grab(group='xerces', module='xercesImpl', version='2.9.1') ])

import groovyx.net.http.*
import static groovyx.net.http.ContentType.URLENC
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*
import groovyx.net.http.*
import org.apache.http.entity.mime.*
import org.apache.http.entity.mime.content.*
import java.nio.charset.Charset
import static groovy.json.JsonOutput.*

def the_base_url = "https://www.whatdotheyknow.com"

def result = []

// HYS is returning CP 1252 pages - need to fix this somehow
// groovyx.net.http.ParserRegistry.setDefaultCharset('cp1252')

def letters = 'a'..'z'
letters.each { letter ->
  process("${the_base_url}/body/list/${letter}", the_base_url, result);
}

try{
  def out= new ObjectOutputStream(new FileOutputStream('wdtk_authorities.obj'))
  out.writeObject(result)
  out.close()
}finally{}



def process(url, base, result_list) {
  def nextPage=url

  while( nextPage != null ) {
    println("\n\n\n${nextPage}\n\n\n");
    nextPage = processPage(nextPage,base, result_list);
  }
}

def processPage(url, base, result_list) {
  println("Processing ${url}");
  def result = null;

  def response_page = new XmlParser( new org.cyberneko.html.parsers.SAXParser() ).parse(url)
  def orgs_on_this_page = response_page.depthFirst().DIV.findAll { it.'@class'=='body_listing' }
  orgs_on_this_page.each { org ->
    processOrg(org.SPAN.A.text(),"${base}${(org.SPAN.A.@href)[0]}", result_list)
  }

  def nextPageLink = response_page.depthFirst().A.findAll { it.'@class' == 'next_page' }
  nextPageLink.each { npl ->
    if ( npl.'@href' != null ) {
      result = "${base}${npl.'@href'}"
    }
  }

  println("Done processing ${url}");
  result
}

def processOrg(name, url, result_list) {
  // println("Processing ${name}, ${url}");
  def response_page = new XmlParser( new org.cyberneko.html.parsers.SAXParser() ).parse(url)
  def types = response_page.depthFirst().P.findAll { it.'@class'=='subtitle' }
  def strtypes = []
  types.each { typep ->
    strtypes.add(typep.A.text());
  }

  def authority_home_page = response_page.depthFirst.A.findAll { it.text() == 'Home page of authority' }
  def foi_email = response_page.depthFirst.A.findAll { it.text() == 'View FOI email address' }
  def publication_scheme = response_page.depthFirst.A.findAll { it.text() == 'Publication Scheme' }

  def result = [
    name:name,
    types:strtypes,
    homepage:authority_home_page,
    foi_email: foi_email,
    publication_scheme: publication_scheme
  ]

  result_list.add(result)
}
