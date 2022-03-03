package com.demoshopping.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {
	private long orderID;
	private String txnRef;
	private String fullname;
	private String email;
	private String phone;
	private String address;
	private String city;
	private BigDecimal sub_total;
	private BigDecimal total;
	private int payment_method;
	private Timestamp created_at;
	private Timestamp updated_at;
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public String getTxnRef() {
		return txnRef;
	}
	public void setTxnRef(String txnRef) {
		this.txnRef = txnRef;
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
	public BigDecimal getSub_total() {
		return sub_total;
	}
	public void setSub_total(BigDecimal sub_total) {
		this.sub_total = sub_total;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public int getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(int payment_method) {
		this.payment_method = payment_method;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", txnRef=" + txnRef + ", fullname=" + fullname + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", city=" + city + ", sub_total=" + sub_total
				+ ", total=" + total + ", payment_method=" + payment_method + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}

	
}
