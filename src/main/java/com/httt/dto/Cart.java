package com.httt.dto;

import java.util.List;

import com.httt.entities.AccountCustomer;

import lombok.Data;

@Data
public class Cart {
	private List<Item> items;
	private AccountCustomer account;
	private Integer quantity;
	private Integer totalPrice;
	private String status;
}
