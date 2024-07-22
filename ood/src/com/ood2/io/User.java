package com.ood2.io;

public class User {
	
	private String name;
	private String city;
	private String email;
	
	public User() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "name=" + this.getName() + ", city=" + this.getCity() + ", email=" + this.getEmail();
	}
	
	

}
