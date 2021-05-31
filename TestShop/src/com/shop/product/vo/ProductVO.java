package com.shop.product.vo;

public class ProductVO {
	
	private String itemCode;
	private String itemName;
	private String itemImage;
	private int price;
	private String itemDesc;
	private int likeIt;
	private String sale;
	private int salePrice;
	private String division;
	private int qtySum;
	private int priceSum;
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public int getLikeIt() {
		return likeIt;
	}
	public void setLikeIt(int likeIt) {
		this.likeIt = likeIt;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public int getQtySum() {
		return qtySum;
	}
	public void setQtySum(int qtySum) {
		this.qtySum = qtySum;
	}
	public int getPriceSum() {
		return priceSum;
	}
	public void setPriceSum(int priceSum) {
		this.priceSum = priceSum;
	}
	@Override
	public String toString() {
		return "ProductVO [itemCode=" + itemCode + ", itemName=" + itemName + ", itemImage=" + itemImage + ", price="
				+ price + ", itemDesc=" + itemDesc + ", likeIt=" + likeIt + ", sale=" + sale + ", salePrice="
				+ salePrice + ", division=" + division + ", qtySum=" + qtySum + ", priceSum=" + priceSum + "]";
	}
}
