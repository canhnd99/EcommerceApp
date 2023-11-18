package com.httt.dto;

import lombok.Builder;
import lombok.Data;

public class PageInfo {
	private Integer totalPages;
	private Integer page;
	
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
}
