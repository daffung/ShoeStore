package com.demoshopping.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AccountMapper implements RowMapper<Account>{

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		account.setuID(rs.getLong(1));
		account.setFullname(rs.getString(2));
		account.setEmail(rs.getString(3));
		account.setPhone(rs.getString(4));
		account.setPassword(rs.getString(5));
		account.setAddress(rs.getString(6));
		account.setCity(rs.getString(7));
		account.setIsSeller(rs.getInt(8));
		account.setIsAdmin(rs.getInt(9));
		return account;
		
	}

	
	
}
