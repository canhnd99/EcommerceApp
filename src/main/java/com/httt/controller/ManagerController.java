package com.httt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.httt.dao.AccountDAO;
import com.httt.dao.CategoryDAO;
import com.httt.dao.OrderDAO;
import com.httt.dao.PaymentDAO;
import com.httt.dao.ProductDAO;
import com.httt.dto.OrderDto;
import com.httt.entities.Account;
import com.httt.entities.Category;
import com.httt.entities.Payment;
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
	
	@Autowired
	private PaymentDAO paymentDAO;
	
	@Autowired
	private OrderDAO orderDAO;

	@RequestMapping(value = { "/admin" })
	public String getSignupForm(HttpServletRequest request, HttpServletResponse resp, Model model) throws IOException {
		Account account = (Account) SessionUtil.getInstance().getValue(request, "ACCOUNT");
		if(account == null || !"ADMIN".equals(account.getRole())) {
			return "error";
		} else {
			List<Category> categories = categoryDAO.getCategories();
			List<Product> products = productDAO.getProducts();
			List<Payment> payments = paymentDAO.getPaymentMethods();
			
			List<Object[]> rawOrders = orderDAO.getOrders();
			List<OrderDto> orders = new ArrayList<>();
			for(Object[] item: rawOrders) {
				OrderDto order = new OrderDto();
				order.setOrderCode((String) item[0]);
				order.setPrice((Integer) item[1]);
				order.setQuantity((Integer) item[2]);
				order.setCreateDate((Date) item[3]);
				orders.add(order);
			}
			
			model.addAttribute("account", account);
			model.addAttribute("categories", categories);
			model.addAttribute("orders", orders);
			model.addAttribute("payments", payments);
			model.addAttribute("products", products);
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
