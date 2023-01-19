package com.fco271292.infrastructure.rest.mapper

import org.springframework.stereotype.Component

import com.fco271292.domain.model.User
import com.fco271292.infrastructure.entity.UserEntity
import com.fco271292.infrastructure.rest.request.UserRequest
import com.fco271292.infrastructure.rest.response.UserResponse

@Component
class UserMapper {
	
	def toUser(UserEntity userEntity) {
		new User(id: userEntity.id, name: userEntity.name)
	}
	
	def toUserEntity(User user) {
		new UserEntity(id: user.id, name: user.name)
	}
	
	def toUserEntity(UserRequest userRequest) {
		new UserEntity(name: userRequest.name)
	}
	
	def toUserResponse(UserEntity userEntity) {
		new UserResponse(userEntity.id, userEntity.name)
	}
}
