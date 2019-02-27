package com.ssm.domain;

public class User {
	
	private Integer uid;
	private String name;
	private Integer age;
	
	public User() {
		super();
	}

	public User(Integer uid, String name, Integer age) {
		super();
		this.uid = uid;
		this.name = name;
		this.age = age;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
