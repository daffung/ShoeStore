package com.demoshopping.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoshopping.DAO.IAuthenticateDAO;
import com.demoshopping.entity.Account;

@Service
public class AuthenticateServiceImpl implements IAuthenticateService{
	@Autowired
	public IAuthenticateDAO authenticateDAO;

	@Override
	public int createAccount(Account account) {
		Account existAccount = authenticateDAO.findAccountByEmail(account.getEmail());
		if(existAccount == null) {
			account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt(10)));
			// TODO Auto-generated method stub
			return authenticateDAO.createAccount(account);
		}else return -1;
		
	}
	@Override
	public Account authenticateAccount(Account account) {
		Account existAccount = authenticateDAO.findAccountByEmail(account.getEmail());
		if(existAccount == null) {
			return null;
		}
		else {
			if(BCrypt.checkpw(account.getPassword(), existAccount.getPassword()))
			{
				return existAccount;
			}else {
				return null;
			}
		}
	}
}
