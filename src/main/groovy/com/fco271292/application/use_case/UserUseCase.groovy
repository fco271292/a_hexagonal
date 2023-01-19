package com.fco271292.application.use_case

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import com.fco271292.infrastructure.entity.UserEntity
import com.fco271292.infrastructure.port.input.EntityRepository
import com.fco271292.infrastructure.port.input.UserInputPort
import com.fco271292.infrastructure.rest.mapper.UserMapper

import ch.qos.logback.classic.Logger

@Component
class UserUseCase implements UserInputPort {
	
	Logger logger = LoggerFactory.getLogger(this.class)
	
	@Autowired
	EntityRepository entityRepository
	
	@Autowired
	UserMapper userMapper

	@Override
	def findById(def id) {
		logger.info "<-- ${id}"
		def userEntity = entityRepository.findById(id)
		def userResponse
		if (userEntity) {
			userResponse = userMapper.toUserResponse(userEntity?.get())
		}		
		logger.info "${userResponse}"
		userResponse
	}

	@Override
	def save(def entity) {
		logger.info "<-- ${entity}"
		def userEntity = entityRepository.save(entity)
		def userResponse = userMapper.toUserResponse(userEntity)
		logger.info "${userResponse}"
		userResponse
	}
	
}
