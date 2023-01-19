package com.fco271292.infrastructure.port.input

interface EntityRepository {
	
	def save(def entity)
	def findById(def id)
	def findAll()
	
}
