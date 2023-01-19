package com.fco271292.infrastructure.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import com.fco271292.application.use_case.UserUseCase
import com.fco271292.domain.port.UserPort
import com.fco271292.infrastructure.rest.mapper.UserMapper

@Configuration
class BeanConfiguration {
	
	@Bean
	UserUseCase userUserCase(UserPort userPort, UserMapper userMapper) {
		new UserUseCase(userPort, userMapper)
	}
	
}