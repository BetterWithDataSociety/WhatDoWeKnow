package org.opendatasheffield.wdwk

import me.ianibbo.common.*

class DataRequest {

  AuthCommonUser requester
  String requestText



  static mapping = {
    table name:'wdwk_data_request'
    requestText column:'request_text', type:'text'
  }

  static constraints = {
    requester(blank: false, nullable:false)
    requestText(blank: false, nullable:false)
  }

}
