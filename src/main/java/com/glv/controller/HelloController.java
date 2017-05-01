package com.glv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glv.domain.Person;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private Person person;

	@RequestMapping("")
	public String hello() {

		return "Hello World," + person.getDesc() + ", random string:" + person.getRandomVal();
	}

}
