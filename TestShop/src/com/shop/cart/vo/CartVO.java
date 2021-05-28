package com.shop.cart.vo;

public class CartVO {

	public String userID;
	public String itemCode;
	public int itemQty;
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	
	@Override
	public String toString() {
		return "CartVO [userID=" + userID + ", itemCode=" + itemCode + ", itemQty=" + itemQty + "]";
	}
	
}
