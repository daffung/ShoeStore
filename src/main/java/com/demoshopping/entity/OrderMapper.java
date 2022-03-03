package com.demoshopping.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OrderMapper implements RowMapper<Order> {
	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order = new Order();
		order.setOrderID(rs.getLong(1));
		order.setTxnRef(rs.getString(2));
		order.setFullname(rs.getString(3));
		order.setEmail(rs.getString(4));
		order.setPhone(rs.getString(5));
		order.setAddress(rs.getString(6));
		order.setCity(rs.getString(7));
		order.setSub_total(rs.getBigDecimal(8));
		order.setTotal(rs.getBigDecimal(9));
		order.setPayment_method(rs.getInt(10));
		order.setCreated_at(rs.getTimestamp(11));
		order.setUpdated_at(rs.getTimestamp(12));
		return order;
	}
}
