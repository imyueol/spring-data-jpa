package com.greedy.practice.dto;

public class KindDTO {
	
	private int productCategory;
	private String categoryName;

	public KindDTO() {}

	public KindDTO(int productCategory, String categoryName) {
		super();
		this.productCategory = productCategory;
		this.categoryName = categoryName;
	}

	public int getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "KindDTO [productCategory=" + productCategory + ", categoryName=" + categoryName + "]";
	}
	
	

	
}
