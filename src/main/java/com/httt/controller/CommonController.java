package com.httt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.httt.dao.CategoryDAO;
import com.httt.entities.Category;
import com.httt.util.SessionUtil;

@Controller
public class CommonController {
	@Value("${rootPath}")
	private String rootPath;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = { "/about" })
	public String about(HttpServletRequest req, Model model) {
		List<Category> categories = categoryDAO.getCategories();
		
		model.addAttribute("categories", categories);
		model.addAttribute("rootPath", rootPath);
		model.addAttribute("account", SessionUtil.getInstance().getValue(req, "ACCOUNT"));
		return "about";
	}
	
	@RequestMapping(value = { "/contact" })
	public String contact(HttpServletRequest req, Model model) {
		List<Category> categories = categoryDAO.getCategories();
		
		model.addAttribute("categories", categories);
		model.addAttribute("rootPath", rootPath);
		model.addAttribute("account", SessionUtil.getInstance().getValue(req, "ACCOUNT"));
		return "contact";
	}
}
