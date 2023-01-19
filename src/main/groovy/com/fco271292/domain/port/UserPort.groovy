package com.fco271292.domain.port

interface UserPort {
	
	def findById(def id)
	def save(def entity)
	def findAll()
	
}
