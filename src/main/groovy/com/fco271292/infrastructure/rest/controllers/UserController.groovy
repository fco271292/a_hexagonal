package com.fco271292.infrastructure.rest.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import com.fco271292.application.use_case.UserUseCase
import com.fco271292.infrastructure.rest.request.UserRequest

@RestController
@RequestMapping(path = "user")
class UserController {
	
//	@Autowired
	UserUseCase userUseCase
	
	UserController(UserUseCase userUseCase) {
		this.userUseCase = userUseCase
	}
	
	@GetMapping(path = "findById")
	def findById(@RequestParam("id") Long id) {
		def body = userUseCase.findById(id)
		def httpStatus = body ? HttpStatus.OK : HttpStatus.NO_CONTENT
		new ResponseEntity(body, httpStatus)
	}
	
	@PostMapping(path = "save")
	def save(@RequestBody UserRequest userRequest) {
		userUseCase.save(userRequest)
	}
	
	@GetMapping(path = "findAll")
	def findAll() {
		userUseCase.findAll()
	}
}
