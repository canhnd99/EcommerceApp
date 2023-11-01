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
}
