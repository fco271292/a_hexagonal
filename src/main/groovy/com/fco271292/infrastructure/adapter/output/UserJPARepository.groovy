package com.fco271292.infrastructure.adapter.output

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import com.fco271292.infrastructure.entity.UserEntity

@Repository
interface UserJPARepository extends JpaRepository<UserEntity, Long> {
	
}