package com.httt.dao;

import com.httt.entities.Account;

public interface AccountDAO {
	boolean signup(Account account);
	
	Account checkLogin(String phone, String password);

	Account findByPhone(String custPhone);
}
