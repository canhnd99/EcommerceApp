package com.httt.dto;

import com.httt.entities.ProductLog;

import lombok.Data;

@Data
public class Item {
	private int id;
	private ProductLog product;
	private int quantity;
	private int price;
}
