package com.hib.entity;

import java.util.Objects;

public class Address {

	private String addrNo;
	private String addrLine1;
	
	private String addrLine2;
	private String city;
	private String state;
	private String zip;
	private String country;
	public String getAddrNo() {
		return addrNo;
	}
	public void setAddrNo(String addrNo) {
		this.addrNo = addrNo;
	}
	public String getAddrLine1() {
		return addrLine1;
	}
	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}
	public String getAddrLine2() {
		return addrLine2;
	}
	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [addrNo=" + addrNo + ", addrLine1=" + addrLine1 + ", addrLine2=" + addrLine2 + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", country=" + country + "]";
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String addrNo, String addrLine1, String addrLine2, String city, String state, String zip,
			String country) {
		super();
		this.addrNo = addrNo;
		this.addrLine1 = addrLine1;
		this.addrLine2 = addrLine2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}
	@Override
	public int hashCode() {
		return Objects.hash(addrLine1, addrLine2, addrNo, city, country, state, zip);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(addrLine1, other.addrLine1) && Objects.equals(addrLine2, other.addrLine2)
				&& addrNo == other.addrNo && Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(state, other.state) && Objects.equals(zip, other.zip);
	}
	
	
}
