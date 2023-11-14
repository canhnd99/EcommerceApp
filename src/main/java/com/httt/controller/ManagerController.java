package com.httt.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.httt.dao.AccountDAO;
import com.httt.dao.CategoryDAO;
import com.httt.dao.ProductDAO;
import com.httt.entities.Account;
import com.httt.entities.Category;
import com.httt.entities.Product;
import com.httt.entities.ProductLog;
import com.httt.util.SessionUtil;

@Controller
public class ManagerController {
	@Value("${rootPath}")
	private String rootPath;

	@Value("${imageResource}")
	private String imageResource;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/admin/products" })
	public String getSignupForm(HttpServletRequest request, HttpServletResponse resp, Model model) throws IOException {
		Account account = (Account) SessionUtil.getInstance().getValue(request, "ACCOUNT");
		if(account == null || !"ADMIN".equals(account.getRole())) {
			return "error";
		} else {
			List<Category> categories = categoryDAO.getCategories();
			List<Product> allProducts = productDAO.getProducts();
			model.addAttribute("account", account);
			model.addAttribute("categories", categories);
			model.addAttribute("products", allProducts);
			model.addAttribute("rootPath", rootPath);
		}
		return "admin";
	}
	
	@RequestMapping(value = { "/admin/new-product-form" })
	public String addProductForm(HttpServletRequest request, Model model) {
		Account account = (Account) SessionUtil.getInstance().getValue(request, "ACCOUNT");
		if(account == null || !"ADMIN".equals(account.getRole())) {
			return "error";
		} else {
			List<Category> categories = categoryDAO.getCategories();
			model.addAttribute("categories", categories);
			model.addAttribute("rootPath", rootPath);
			return "add-product";
		}
	}
	
	@RequestMapping(value = {"/admin/product/add"})
	public String addProduct(HttpServletRequest request, Model model) {
		Account account = (Account) SessionUtil.getInstance().getValue(request, "ACCOUNT");
		if(account == null || !"ADMIN".equals(account.getRole())) {
			return "error";
		} else {
			String name = request.getParameter("name");
			Integer quantity = Integer.parseInt(request.getParameter("quantity")); 
			Integer price = Integer.parseInt(request.getParameter("price")); 
			String description = request.getParameter("description");
			Integer categoryId = Integer.parseInt(request.getParameter("category"));
			Integer discount = Integer.parseInt(request.getParameter("discount"));
			String code = request.getParameter("code");
			String picture = request.getParameter("picture");
			
			ProductLog product = ProductLog.builder()
					.name(name)
					.productCode(code)
					.quantity(quantity)
					.price(price)
					.picture(picture)
					.discount(discount)
					.description(description)
					.categoryId(categoryId)
					.build();
			
			boolean isAdded = productDAO.addNew(product);
			
			List<Product> allProducts = productDAO.getProducts();
			List<Category> categories = categoryDAO.getCategories();
			model.addAttribute("categories", categories);
			model.addAttribute("products", allProducts);
			model.addAttribute("rootPath", rootPath);
			return "admin";
		}
	}
}
