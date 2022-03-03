package com.demoshopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.demoshopping.entity.Account;
import com.demoshopping.entity.AccountMapper;


@Repository
public class AuthenticateDAOImpl extends BaseDAO implements IAuthenticateDAO {

	@Override
	public int createAccount(Account account) {
		String sql = "INSERT INTO sql_shoppingcart.account (fullname, email, phone, password, address, city) VALUES (?,?,?,?,?,?)";
		PreparedStatementCreator statementCreator = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pStatement = con.prepareStatement(sql);
				pStatement.setString(1, account.getFullname());
				pStatement.setString(2, account.getEmail());
				pStatement.setString(3, account.getPhone());
				pStatement.setString(4, account.getPassword());
				pStatement.setString(5, account.getAddress());
				pStatement.setString(6, account.getCity());
				
				return pStatement;
			}
		};
					
		int update = _jdbcTemplate.update(statementCreator);
		System.out.print(update);
		return update;
	}
	@Override
	public Account findAccountByEmail(String email) {
		String sql = "SELECT * FROM sql_shoppingcart.account WHERE email = ?";
		try {
			Account account =  _jdbcTemplate.queryForObject(sql, new Object[] {email}, new AccountMapper());
			System.out.print(account);
			return account;
		} catch (DataAccessException e) {
			return null;
		}
		
	}
}
