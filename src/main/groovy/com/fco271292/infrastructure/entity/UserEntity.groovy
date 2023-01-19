package com.fco271292.infrastructure.entity

import java.time.LocalDateTime

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Version

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp

import groovy.transform.Canonical

@Canonical(includeNames = true, includePackage = false)
@Entity
class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id
	
	@Version
	Integer version
	
	@CreationTimestamp
	LocalDateTime dateCreated
	
	@UpdateTimestamp
	LocalDateTime lastUpdated
	
	String name
	
}
