package com.fco271292.application.use_case

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

import com.fco271292.domain.port.UserPort
import com.fco271292.infrastructure.rest.mapper.UserMapper

import ch.qos.logback.classic.Logger

//@Component
class UserUseCase {
	
	Logger logger = LoggerFactory.getLogger(this.class)
	
	UserPort userPort
	UserMapper userMapper
	
	UserUseCase (UserPort userPort, UserMapper userMapper) {
		this.userPort = userPort
		this.userMapper = userMapper
	}
	
	def findById(def id) {
		logger.info "<-- ${id}"
		def userEntity = userPort.findById(id)
		def userResponse
		if (userEntity) {
			userResponse = userMapper.toUserResponse(userEntity?.get())
		}		
		logger.info "--> ${userResponse}"
		userResponse
	}

	def save(def entity) {
		logger.info "<-- ${entity}"
		def userEntity = userPort.save(entity)
		def userResponse = userMapper.toUserResponse(userEntity)
		logger.info "--> ${userResponse}"
		userResponse
	}

	def findAll() {
		def userEntityList = userPort.findAll()
		logger.info "--> List: ${userEntityList?.size()}"
		def userResponseList = userEntityList?.collect { userEntity -> userMapper.toUserResponse(userEntity)}
		userResponseList
	}	
	
}
