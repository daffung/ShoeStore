package com.demoshopping.entity;

public class Account {
	private long uID;
	private String fullname;
	private String email;
	private String phone;
	private String password;
	private String address;
	private String city;
	private int isSeller;
	private int isAdmin;
	public long getuID() {
		return uID;
	}
	public void setuID(long uID) {
		this.uID = uID;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getIsSeller() {
		return isSeller;
	}
	public void setIsSeller(int isSeller) {
		this.isSeller = isSeller;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "Account [uID=" + uID + ", fullname=" + fullname + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", address=" + address + ", city=" + city + ", isSeller=" + isSeller
				+ ", isAdmin=" + isAdmin + "]";
	}
	
}
