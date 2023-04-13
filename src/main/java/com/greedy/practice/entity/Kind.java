package com.greedy.practice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="TBL_KIND")
@TableGenerator(
		name="KIND_SEQ_TABLE_GENERATOR",
		table="TBL_KIND_SEQUENCES",
		pkColumnValue="MY_SEQ_KIND_NO",
		allocationSize=1
)		
public class Kind {
	
	@Id
	@Column(name="PRODUCT_CATEGORY")
	@GeneratedValue(strategy = GenerationType.TABLE, generator="KIND_SEQ_TABLE_GENERATOR")
	private int productCategory;
	@Column(name="CATEGORY_NAME")
	private String categoryName;

	public Kind() {}

	public Kind(int productCategory, String categoryName) {
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
		return "Kind [productCategory=" + productCategory + ", categoryName=" + categoryName + "]";
	}
	
	

	
}
