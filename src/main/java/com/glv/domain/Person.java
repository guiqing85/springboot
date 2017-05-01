package com.glv.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

	@Value("${com.glv.id}")
	private long id;
	@Value("${com.glv.name}")
	private String name;
	@Value("${com.glv.detail}")
	private String detail;
	@Value("${com.glv.desc}")
	private String desc;
	@Value("${random.val}")
	private String randomVal;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRandomVal() {
		return randomVal;
	}

	public void setRandomVal(String randomVal) {
		this.randomVal = randomVal;
	}

}
