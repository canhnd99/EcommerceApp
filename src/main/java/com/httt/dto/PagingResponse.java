package com.httt.dto;

import java.util.List;

import com.httt.entities.ProductLog;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PagingResponse {
	private List<ProductLog> products;
	private List<PageInfo> pageInfo;
}
