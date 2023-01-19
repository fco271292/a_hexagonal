package com.fco271292.infrastructure.port.input

interface UserInputPort {
	
	def findById(def id)
	def save(def entity)
	def findAll()
}
