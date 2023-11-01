package com.httt.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;

public class FormUtil {
	@SuppressWarnings({ "deprecation" })
	public static <T> T toModel(Class<T> clazz, HttpServletRequest request) {
		T object = null;
		try {
			object = clazz.newInstance();
			BeanUtils.copyProperties(object, request.getParameterMap());
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.print(e.getMessage());
		}
		return object;
	}
}
