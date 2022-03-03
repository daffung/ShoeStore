package com.demoshopping.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setpID(rs.getLong(1));
		product.setName(rs.getString(2));		
		product.setImage(rs.getString(3));
		product.setPrice(rs.getString(4));
		product.setTitle(rs.getString(5));
		product.setDescription(rs.getString(6));
		product.setCateID(rs.getInt(7));		
		product.setSellID(rs.getInt(8));
		product.setCreated_at(rs.getTimestamp(9));
		product.setUpdated_at(rs.getTimestamp(10));
		return product;
	}
	
}
