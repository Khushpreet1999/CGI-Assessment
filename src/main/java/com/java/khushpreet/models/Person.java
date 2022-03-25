package com.java.khushpreet.models;

public class Person {
	
	private String name;
	private int age;
	private String gender;
	private float propbality;
	public Person()
	{
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public float getPropbality() {
		return propbality;
	}
	public void setPropbality(float propbality) {
		this.propbality = propbality;
	}
	public Person(String name, int age, String gender, float propbality) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.propbality = propbality;
	}
	

}
