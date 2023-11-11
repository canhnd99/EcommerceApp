package com.httt.util;

import java.util.ArrayList;
import java.util.List;

import com.httt.dto.PageInfo;
import com.httt.dto.PagingResponse;
import com.httt.entities.ProductLog;

public class PagingUtil {
	public static PagingResponse getPagingResponse(List<ProductLog> allProducts, Integer pageSize, Integer page) {
		Integer currentPage = null;
		if (page == null || page == 1) {
			currentPage = 1;
		} else {
			currentPage = page;
		}

		Integer size = pageSize * currentPage + (currentPage - 1);
		List<ProductLog> products = new ArrayList<>();
		if (size <= allProducts.size() - 1) {
			for (int idx = size-pageSize; idx <= size; idx++) {
				products.add(allProducts.get(idx));
			}
		} else {
			for (int idx = size-pageSize; idx <= allProducts.size()-1; idx++) {
				products.add(allProducts.get(idx));
			}
		}
		
		// create pageInfo
		List<PageInfo> pageInfo = new ArrayList<>();
		Integer totalPages = allProducts.size() / pageSize + 1;
		for(int idx=0; idx<totalPages; idx++) {
			PageInfo info = PageInfo.builder()
					.totalPages(totalPages)
					.page(idx+1)
					.build();
			pageInfo.add(info);
		}
		
		PagingResponse response = PagingResponse.builder()
				.products(products)
				.pageInfo(pageInfo)
				.build();
		return response;
	}

}
