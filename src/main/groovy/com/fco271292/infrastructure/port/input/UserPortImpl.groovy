package com.fco271292.infrastructure.port.input

import org.springframework.stereotype.Repository

import com.fco271292.domain.port.UserPort
import com.fco271292.infrastructure.adapter.output.UserJPARepository
import com.fco271292.infrastructure.rest.mapper.UserMapper

@Repository
class UserPortImpl implements UserPort {
	
	UserMapper userMapper
	UserJPARepository userJPARepository
	
	UserPortImpl(UserMapper userMapper, UserJPARepository userJPARepository) {
		this.userMapper = userMapper
		this.userJPARepository = userJPARepository
	}

	@Override
	def findById(def id) {
		userJPARepository.findById(id)
	}
	
	@Override
	def save(def entity) {
		entity = userMapper.toUserEntity(entity)
		userJPARepository.save(entity)
	}

	@Override
	def findAll() {
		def userEntityList = userJPARepository.findAll()
	}
}
