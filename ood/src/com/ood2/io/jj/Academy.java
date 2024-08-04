package com.ood2.io.jj;

public class Academy {
	private String street;
	private String city;
	private String province;
	private String zipCode;

	public Academy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Academy(String street, String city, String province, String zipCode) {
		super();
		this.street = street;
		this.city = city;
		this.province = province;
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
