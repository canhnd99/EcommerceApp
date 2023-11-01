package com.httt.dao;

import com.httt.entities.AccountCustomer;

public interface AccountCustomerDAO {
	boolean signup(AccountCustomer account);
	
	AccountCustomer checkLogin(String phone, String password);
}
