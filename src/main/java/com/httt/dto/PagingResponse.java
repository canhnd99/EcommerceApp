package com.httt.dto;

import java.util.List;

import com.httt.entities.Product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PagingResponse {
	private List<Product> products;
	private List<PageInfo> pageInfo;
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<PageInfo> getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(List<PageInfo> pageInfo) {
		this.pageInfo = pageInfo;
	}
	
	
}
