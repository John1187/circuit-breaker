package com.java.user.client;



public class User {
	
	int id;
	String name;
	int age;
	String sex;
	String address;
	String accountDetails;
	
	public User(){
		super();
	}
	
	public User(int id, String name, int age, String sex, String address, String accountDetails){
		
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.accountDetails = accountDetails;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSex() {
		return sex;
	}
	public String getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(String accountDetails) {
		this.accountDetails = accountDetails;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString(){
	    //System.err.println(return org.apache.commons.lang3.builder.ReflectionToStringBuilder.toString();this);
		return "dummy";
	}

	
	
	
	

}
