package com.httt.dto;

import com.httt.entities.Product;

import lombok.Data;

@Data
public class Item {
	private int id;
	private Product product;
	private int quantity;
	private int price;
}
