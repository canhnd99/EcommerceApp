package com.httt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.httt.dao.CategoryDAO;
import com.httt.dao.PaymentDAO;
import com.httt.dao.ProductDAO;
import com.httt.dao.TransportDAO;
import com.httt.dto.Cart;
import com.httt.dto.Item;
import com.httt.entities.Category;
import com.httt.entities.Payment;
import com.httt.entities.ProductLog;
import com.httt.entities.Transport;
import com.httt.util.SessionUtil;

@Controller
public class CartController {
	@Value("${rootPath}")
	private String rootPath;

	@Value("${imageResource}")
	private String imageResource;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private TransportDAO transportDAO;
	
	@Autowired
	private PaymentDAO paymentDAO;
	
	@RequestMapping(value = { "/cart/view" })
	public String product(HttpServletRequest req, HttpServletResponse resp, Model model) {
		List<Category> categories = categoryDAO.getCategories();
		List<Payment> payments = paymentDAO.getPaymentMethods();
		List<Transport> transports = transportDAO.getTransports();
				
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		session.setAttribute("cart", cart);
		
		model.addAttribute("categories", categories);
		model.addAttribute("payments", payments);
		model.addAttribute("transports", transports);
		model.addAttribute("rootPath", rootPath);
		model.addAttribute("account", SessionUtil.getInstance().getValue(req, "ACCOUNT"));
		return "shoping_cart";
	}
	
	@RequestMapping(value = { "/cart/add" })
	public String addToCart(HttpServletRequest req, HttpServletResponse resp, Model model) {
		List<Category> categories = categoryDAO.getCategories();
		List<Payment> payments = paymentDAO.getPaymentMethods();
		List<Transport> transports = transportDAO.getTransports();
		
		int quantity = 1;
		int totalQuantity = 0;
		int totalPrice = 0;
		int prodId;
		
		if(req.getParameter("productId") != null) {
			prodId = Integer.parseInt(req.getParameter("productId"));
			
			ProductLog product = productDAO.findById(prodId);
			if(product != null) {
				if(req.getParameter("quantity") != null) {
					quantity = Integer.parseInt(req.getParameter("quantity"));
					
					int dbQuantity = product.getQuantity();
				}
				Cart cart;
				
				HttpSession session = req.getSession();
				if(session.getAttribute("cart") == null) {
					cart = new Cart();
					List<Item> items = new ArrayList<>();
					
					Item item = new Item();
					item.setQuantity(quantity);
					item.setProduct(product);
					item.setPrice(product.getPrice() - product.getDiscount());
					
					items.add(item);
					cart.setItems(items);
					
					for(Item i: items) {
						totalQuantity += i.getQuantity();
						totalPrice += (i.getProduct().getPrice() - i.getProduct().getDiscount()) * i.getQuantity();
					}
										
				} else {
					cart = (Cart) session.getAttribute("cart");
					List<Item> items = cart.getItems();
					boolean check = false;
					for(Item item: items) {
						if(item.getProduct().getProductId() == product.getProductId()) {
							item.setQuantity(item.getQuantity() + quantity);
							check = true;
						}
					}
					if(check==false) {
						Item item = new Item();
						item.setQuantity(quantity);
						item.setProduct(product);
						item.setPrice(product.getPrice());
						items.add(item);
					}
					
					for(Item i: items) {
						totalQuantity += i.getQuantity();
						totalPrice += (i.getProduct().getPrice() - i.getProduct().getDiscount()) * i.getQuantity();
					}
				}
				cart.setQuantity(totalQuantity);
				cart.setTotalPrice(totalPrice);
				session.setAttribute("cart", cart);
			}
		}
		
		model.addAttribute("payments", payments);
		model.addAttribute("transports", transports);
		model.addAttribute("categories", categories);
		model.addAttribute("rootPath", rootPath);
		model.addAttribute("account", SessionUtil.getInstance().getValue(req, "ACCOUNT"));
		return "shoping_cart";
	}
}
