package com.httt.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.httt.dao.AccountDAO;
import com.httt.dao.CategoryDAO;
import com.httt.dao.PaymentDAO;
import com.httt.dao.ProductDAO;
import com.httt.dto.PagingResponse;
import com.httt.entities.Account;
import com.httt.entities.Category;
import com.httt.entities.Payment;
import com.httt.entities.Product;
import com.httt.util.PagingUtil;
import com.httt.util.PasswordUtil;
import com.httt.util.SessionUtil;

@Controller
public class PaymentController {
	@Value("${rootPath}")
	private String rootPath;
	
	@Value("${imageResource}")
	private String imageResource;
	
	@Value("${numberOfBestSaleProds}")
	private Integer numberOfBestSaleProds;
	
	@Value("${numberOfNewestProducts}")
	private Integer numberOfNewestProducts;
	
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private PaymentDAO paymentDAO;
	
	@RequestMapping(value = {"/payment/add"}, method = RequestMethod.POST)
	public String signup(HttpServletRequest req, HttpServletResponse resp, Model model) throws IOException {
		String message = "";
		
		Account account = (Account) SessionUtil.getInstance().getValue(req, "ACCOUNT");
		if(account == null) {
			message = "Quý khách vui lòng đăng nhập hoặc tạo tài khoản để thanh toán!";
			model.addAttribute("message", message);
			return "error";
		} else {
			String custName = req.getParameter("custName");
			String custAddress = req.getParameter("custAddress");
			String custPhone = req.getParameter("custPhone");
			String accountNo = req.getParameter("accountNo");
			String accountName = req.getParameter("accountName");
			String orderCode = req.getParameter("orderCode");
			Integer paymentType = Integer.parseInt(req.getParameter("paymentType"));
			
			Account custAccount = accountDAO.findByPhone(custPhone);
			if(custAccount != null) {
				Payment payment = new Payment();
				payment.setPaymentType(paymentType);
				payment.setAccountNo(accountNo);
				payment.setOrderCode(orderCode);
				payment.setAccountName(accountName);
				payment.setCreateDate(new Date());
				
				paymentDAO.addPayment(payment);
				message = "Thanh toán thành công, cảm ơn quý khách!";
			} else {
				message = "Không tìm thấy thông tin khách hàng với số điện thoại: " + custPhone;
			}
			resp.sendRedirect(rootPath);
			List<Product> allProducts = productDAO.getProducts();
			List<Category> categories = categoryDAO.getCategories();
			model.addAttribute("products", allProducts);
			model.addAttribute("categories", categories);
			model.addAttribute("account", SessionUtil.getInstance().getValue(req, "ACCOUNT"));
			model.addAttribute("message", message);
			return "index";
		}
	}
}
