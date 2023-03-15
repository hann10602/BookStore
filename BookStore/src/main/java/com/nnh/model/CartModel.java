package com.nnh.model;

public class CartModel extends AbstractModel<CartModel>{
	private Integer quantity;
	private Long bookId;
	private Long userId;
	private Long bookPrice;
	private String bookTitle;
	private String bookThumbnail;
	private Long totalMoney;
	
	

	public Long getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Long totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Long getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Long bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookThumbnail() {
		return bookThumbnail;
	}

	public void setBookThumbnail(String bookThumbnail) {
		this.bookThumbnail = bookThumbnail;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
