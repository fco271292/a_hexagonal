package com.fco271292.infrastructure.adapter.output

import org.springframework.data.jpa.repository.JpaRepository

import com.fco271292.infrastructure.entity.UserEntity

interface UserJPARepository extends JpaRepository<UserEntity, Long> {
	
}