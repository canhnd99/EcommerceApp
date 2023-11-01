package com.httt.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
	@Id
	@Column(name = "productId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
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
}
