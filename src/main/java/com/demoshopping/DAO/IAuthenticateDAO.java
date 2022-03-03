package com.demoshopping.DAO;

import org.springframework.stereotype.Repository;

import com.demoshopping.entity.Account;

@Repository
public interface IAuthenticateDAO {
	public int createAccount(Account account);
	public Account findAccountByEmail(String email);
}
