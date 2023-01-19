package com.fco271292.infrastructure.rest.response

import groovy.transform.Canonical

@Canonical(includeNames = true, includePackage = false)
class UserResponse {
	def id
	def name
}
