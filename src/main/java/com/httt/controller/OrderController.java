package com.httt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.httt.dao.CategoryDAO;
import com.httt.dao.OrderDAO;
import com.httt.dao.OrderDetailDAO;
import com.httt.dao.PaymentDAO;
import com.httt.dao.ProductDAO;
import com.httt.dto.Cart;
import com.httt.dto.Item;
import com.httt.entities.Account;
import com.httt.entities.Category;
import com.httt.entities.Order;
import com.httt.entities.OrderDetail;
import com.httt.entities.Payment;
import com.httt.entities.Product;
import com.httt.util.SessionUtil;

import jakarta.transaction.Transactional;

@Controller
public class OrderController {
	@Value("${rootPath}")
	private String rootPath;

	@Value("${imageResource}")
	private String imageResource;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private PaymentDAO paymentDAO;
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	
	@RequestMapping(value = { "/cart/view" })
	public String product(HttpServletRequest req, HttpServletResponse resp, Model model) {
		List<Category> categories = categoryDAO.getCategories();
		List<Payment> payments = paymentDAO.getPaymentMethods();
				
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		session.setAttribute("cart", cart);
		
		model.addAttribute("categories", categories);
		model.addAttribute("payments", payments);
		model.addAttribute("rootPath", rootPath);
		model.addAttribute("account", SessionUtil.getInstance().getValue(req, "ACCOUNT"));
		return "shoping_cart";
	}
	
	@Transactional
	@RequestMapping(value = { "/cart/add" })
	public String addToCart(HttpServletRequest req, HttpServletResponse resp, Model model) {
		List<Category> categories = categoryDAO.getCategories();
		List<Payment> payments = paymentDAO.getPaymentMethods();
		
		int quantity = 1;
		int totalQuantity = 0;
		int totalPrice = 0;
		int prodId;
		
		Account account = (Account)SessionUtil.getInstance().getValue(req, "ACCOUNT");
		Order order = new Order();
		if(req.getParameter("productId") != null) {
			prodId = Integer.parseInt(req.getParameter("productId"));
			
			Product product = productDAO.findById(prodId);
			if(product != null) {
				if(req.getParameter("quantity") != null) {
					quantity = Integer.parseInt(req.getParameter("quantity"));
					
					int dbQuantity = product.getQuantity();
				}
				
				HttpSession session = req.getSession();
				SessionUtil.getInstance().removeValue(req, "cart");
				Cart cart = new Cart();
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
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");	
				Date date = new Date();
				
				String orderCode = product.getProductCode() + sdf.format(new Date());
				order.setOrderCode(orderCode);
				order.setTotalPrice(totalPrice);
				order.setCreateDate(date);
				order.setCustomerId(Objects.nonNull(account) ? account.getCustomerId() : null);
				boolean isOrderAdded = orderDAO.addOrder(order);
				
				if(isOrderAdded) {
					order = orderDAO.findByOrderCode(orderCode);
					for(Item it: items) {
						OrderDetail orderDetail = new OrderDetail();
						orderDetail.setOrderId(order.getOrderId());
						orderDetail.setQuantity(it.getQuantity());
						orderDetail.setPrice(it.getPrice());
						orderDetail.setProductId(product.getProductId());
						orderDetail.setCreateDate(date);
						
						orderDetailDAO.addOrderDetail(orderDetail);
					}
				}
				
				cart.setQuantity(totalQuantity);
				cart.setTotalPrice(totalPrice);
				session.setAttribute("cart", cart);
			}
		}
		
		model.addAttribute("payments", payments);
		model.addAttribute("categories", categories);
		model.addAttribute("order", order);
		model.addAttribute("rootPath", rootPath);
		model.addAttribute("account", account);
		return "shoping_cart";
	}
}
