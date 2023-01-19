package com.fco271292.infrastructure.adapter.output

import java.time.LocalDateTime

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import com.fco271292.infrastructure.entity.UserEntity
import com.fco271292.infrastructure.port.input.EntityRepository
import com.fco271292.infrastructure.rest.mapper.UserMapper

import ch.qos.logback.classic.Logger

@Component
class UserRepository implements EntityRepository {
	
	Logger logger = LoggerFactory.getLogger(this.class)
	
	@Autowired
	UserJPARepository userJPARepository
	
	@Autowired
	UserMapper userMapper

	@Override
	def save(def entity) {
		entity = userMapper.toUserEntity(entity)
		userJPARepository.save(entity)
	}

	@Override
	def findById(def id) {
		def user = userJPARepository.findById(id)
	}

	@Override
	def findAll() {
		def userEntityList = userJPARepository.findAll()
	}
	
}
