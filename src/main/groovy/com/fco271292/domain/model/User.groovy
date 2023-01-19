package com.fco271292.domain.model

import groovy.transform.Canonical

@Canonical(includeNames = true, includePackage = false)
class User {
	
	Long id
	String name
	
}
