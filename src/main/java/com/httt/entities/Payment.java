package com.httt.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_payment")
public class Payment {
	@Id
	@Column(name = "paymentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;
	
	@Column(name = "paymentType")
	private Integer paymentType;
	
	@Column(name = "providerName")
	private String providerName;
	
	@Column(name = "providerCode")
	private String providerCode;
	
	@Column(name = "accountNo")
	private String accountNo;
	
	@Column(name = "createDate")
	private Date createDate;
	
	@Column(name = "modifyDate")
	private Date modifyDate;
}
