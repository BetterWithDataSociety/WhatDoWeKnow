package org.opendatasheffield.wdwk

import org.apache.commons.lang.builder.HashCodeBuilder

class WdwkUserWdwkRole implements Serializable {

	private static final long serialVersionUID = 1

	WdwkUser wdwkUser
	WdwkRole wdwkRole

	boolean equals(other) {
		if (!(other instanceof WdwkUserWdwkRole)) {
			return false
		}

		other.wdwkUser?.id == wdwkUser?.id &&
			other.wdwkRole?.id == wdwkRole?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (wdwkUser) builder.append(wdwkUser.id)
		if (wdwkRole) builder.append(wdwkRole.id)
		builder.toHashCode()
	}

	static WdwkUserWdwkRole get(long wdwkUserId, long wdwkRoleId) {
		WdwkUserWdwkRole.where {
			wdwkUser == WdwkUser.load(wdwkUserId) &&
			wdwkRole == WdwkRole.load(wdwkRoleId)
		}.get()
	}

	static WdwkUserWdwkRole create(WdwkUser wdwkUser, WdwkRole wdwkRole, boolean flush = false) {
		new WdwkUserWdwkRole(wdwkUser: wdwkUser, wdwkRole: wdwkRole).save(flush: flush, insert: true)
	}

	static boolean remove(WdwkUser u, WdwkRole r, boolean flush = false) {

		int rowCount = WdwkUserWdwkRole.where {
			wdwkUser == WdwkUser.load(u.id) &&
			wdwkRole == WdwkRole.load(r.id)
		}.deleteAll()

		rowCount > 0
	}

	static void removeAll(WdwkUser u) {
		WdwkUserWdwkRole.where {
			wdwkUser == WdwkUser.load(u.id)
		}.deleteAll()
	}

	static void removeAll(WdwkRole r) {
		WdwkUserWdwkRole.where {
			wdwkRole == WdwkRole.load(r.id)
		}.deleteAll()
	}

	static mapping = {
		id composite: ['wdwkRole', 'wdwkUser']
		version false
	}
}
