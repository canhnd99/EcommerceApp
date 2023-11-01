package com.httt.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageInfo {
	private Integer totalPages;
	private Integer page;
}
