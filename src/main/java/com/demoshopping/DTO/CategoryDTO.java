package com.demoshopping.DTO;

public class CategoryDTO {
	private int cID;
	private String cname;
	private int amount;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@Override
	public String toString() {
		return "CategoryDTO [cID=" + cID + ", cname=" + cname + ", amount=" + amount + "]";
	}
}
