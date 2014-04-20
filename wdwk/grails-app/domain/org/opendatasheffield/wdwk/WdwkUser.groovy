package org.opendatasheffield.wdwk

class WdwkUser {

  transient springSecurityService

  String username
  String password
  boolean enabled = true
  boolean accountExpired
  boolean accountLocked
  boolean passwordExpired

  static transients = ['springSecurityService']

  static constraints = {
    username blank: false, unique: true
    password blank: false
  }

  // static mapping = {
  //   table name:, schema:'', catalog:''
  // }

  static hasMany = [
    oAuthIDs : WdwdOauthID
  ]

  static mapping = {
    password column: '`password`'
  }

  Set<WdwkRole> getAuthorities() {
    WdwkUserWdwkRole.findAllByWdwkUser(this).collect { it.wdwkRole } as Set
  }

  def beforeInsert() {
    encodePassword()
  }

  def beforeUpdate() {
    if (isDirty('password')) {
      encodePassword()
    }
  }

  protected void encodePassword() {
    password = springSecurityService.encodePassword(password)
  }
}
