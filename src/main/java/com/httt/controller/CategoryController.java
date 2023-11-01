package com.httt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.httt.dao.CategoryDAO;
import com.httt.entities.Category;

@Controller
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/categories" })
	public String product(Model model) {
		List<Category> categories = categoryDAO.getCategories();
		
		model.addAttribute("products", categories);
		return "product";
	}
}
