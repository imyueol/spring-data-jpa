package com.greedy.practice.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

public class ProductDTO {

	private int productNo;
	private String productName;
	private int productPrice;
	private java.sql.Date releaseDate;
	private String productCodeName;
	private String productCategory;

	public ProductDTO() {}

	public ProductDTO(int productNo, String productName, int productPrice, Date releaseDate, String productCodeName,
				String productCategory) {
			super();
			this.productNo = productNo;
			this.productName = productName;
			this.productPrice = productPrice;
			this.releaseDate = releaseDate;
			this.productCodeName = productCodeName;
			this.productCategory = productCategory;
		}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public java.sql.Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(java.sql.Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getProductCodeName() {
		return productCodeName;
	}

	public void setProductCodeName(String productCodeName) {
		this.productCodeName = productCodeName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "ProductDTO [productNo=" + productNo + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", releaseDate=" + releaseDate + ", productCodeName=" + productCodeName + ", productCategory="
				+ productCategory + "]";
	}

}
