package com.httt.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.httt.dao.AccountCustomerDAO;
import com.httt.dao.CategoryDAO;
import com.httt.entities.AccountCustomer;
import com.httt.entities.Category;
import com.httt.util.PasswordUtil;
import com.httt.util.SessionUtil;


@Controller
public class AccountController {
	@Value("${rootPath}")
	private String rootPath;

	@Value("${imageResource}")
	private String imageResource;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private AccountCustomerDAO accountDAO;

	@RequestMapping(value = { "/account/signup-form" })
	public String getSignupForm(HttpServletRequest request, Model model) {
		List<Category> categories = categoryDAO.getCategories();

		model.addAttribute("categories", categories);
		model.addAttribute("rootPath", rootPath);
		return "signup";
	}

	@RequestMapping(value = { "/account/signup" })
	public String signup(HttpServletRequest req, Model model) {
		List<Category> categories = categoryDAO.getCategories();

		String fullname = req.getParameter("fullname");
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String password = req.getParameter("password");
		
		String encodePass = PasswordUtil.getMD5Password(password);

		AccountCustomer account = AccountCustomer.builder()
				.customerId(UUID.randomUUID().toString())
				.fullName(fullname)
				.username(username)
				.email(email)
				.address(address)
				.phone(phone)
				.password(encodePass)
				.build();

		boolean isRegis = accountDAO.signup(account);
		
		model.addAttribute("categories", categories);
		model.addAttribute("rootPath", rootPath);
		
		if(isRegis) {			
			return "signin";
		}
		return "index";
	}

	@RequestMapping(value = { "/account/signin-form" })
	public String getSigninForm(HttpServletRequest request, Model model) {
		List<Category> categories = categoryDAO.getCategories();

		model.addAttribute("categories", categories);
		model.addAttribute("rootPath", rootPath);
		return "signin";
	}

	@RequestMapping(value = { "/account/signin" }, method = RequestMethod.POST)
	public void login(HttpServletRequest req, HttpServletResponse resp, Model model) throws IOException {
		String phone = req.getParameter("phone");
		String password = req.getParameter("password");
		
		String encodePass = PasswordUtil.getMD5Password(password);

		AccountCustomer loginAccount = accountDAO.checkLogin(phone, encodePass);
		
		if(loginAccount != null) {
			SessionUtil.getInstance().putValue(req, "ACCOUNT", loginAccount);
			resp.sendRedirect(rootPath);
		} else {
			resp.sendRedirect(rootPath + "/account/login-fail");
		}
	}
	
	@RequestMapping(value = { "/account/signout" })
	public void logout(HttpServletRequest req, HttpServletResponse resp, Model model) throws IOException {		
		SessionUtil.getInstance().removeValue(req, "ACCOUNT");
		SessionUtil.getInstance().removeValue(req, "cart");

		resp.sendRedirect(rootPath);
	}
	
	@RequestMapping(value = { "/account/login-fail" })
	public String loginFail(HttpServletRequest req, HttpServletResponse resp, Model model) throws IOException {		
		
		return "login_fail";
	}
}
