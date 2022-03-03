package com.demoshopping.service;

import org.springframework.stereotype.Service;

import com.demoshopping.entity.Account;

@Service
public interface IAuthenticateService {
	public int createAccount(Account account);
	public Account authenticateAccount(Account account);
}
