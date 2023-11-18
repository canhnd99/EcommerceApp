package com.httt.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_product_log")
public class ProductLog implements Serializable {
	@Id
	@Column(name = "productId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	@Column(name = "productCode")
	private String productCode;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "status")
	private Integer status;
	
	@Column(name = "discount")
	private Integer discount;
	
	@Column(name = "picture")
	private String picture;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "createDate")
	private Date createDate;
	
	@Column(name = "startDateDiscount")
	private Date startDateDiscount;
	
	@Column(name = "endDateDiscount")
	private Date endDateDiscount;
	
	@Column(name = "categoryId")
	private Integer categoryId;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getStartDateDiscount() {
		return startDateDiscount;
	}

	public void setStartDateDiscount(Date startDateDiscount) {
		this.startDateDiscount = startDateDiscount;
	}

	public Date getEndDateDiscount() {
		return endDateDiscount;
	}

	public void setEndDateDiscount(Date endDateDiscount) {
		this.endDateDiscount = endDateDiscount;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
}
