package com.httt.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_order_detail")
public class OrderDetail {
	@Id
	@Column(name = "orderDetailId")
	private String orderDetailId;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "createDate")
	private Date createDate;
	
	@Column(name = "modifyDate")
	private Date modifyDate;
	
	@Column(name = "orderId")
	private Integer orderId;
	
	@Column(name = "productId")
	private Integer productId;
}
