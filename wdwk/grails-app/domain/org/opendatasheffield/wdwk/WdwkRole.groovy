package org.opendatasheffield.wdwk

class WdwkRole {

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}
}
