package com.httt.util;

import java.util.ArrayList;
import java.util.List;

import com.httt.dto.PageInfo;
import com.httt.dto.PagingResponse;
import com.httt.entities.Product;

public class PagingUtil {
	public static PagingResponse getPagingResponse(List<Product> allProducts, Integer pageSize, Integer page) {
		Integer currentPage = null;
		if (page == null || page == 1) {
			currentPage = 1;
		} else {
			currentPage = page;
		}

		Integer size = pageSize * currentPage + (currentPage - 1);
		List<Product> products = new ArrayList<>();
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
			PageInfo info = new PageInfo();
			info.setPage(idx+1);
			info.setTotalPages(totalPages);
				
			pageInfo.add(info);
		}
		
		PagingResponse response = new PagingResponse();
		response.setProducts(products);
		response.setPageInfo(pageInfo);
				
		return response;
	}

}
