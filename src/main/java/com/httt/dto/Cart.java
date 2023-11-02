package com.httt.dto;

import java.util.List;

import com.httt.entities.Account;

import lombok.Data;

@Data
public class Cart {
	private List<Item> items;
	private Account account;
	private Integer quantity;
	private Integer totalPrice;
	private String status;
}
