package com.demoshopping.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CategoryDTOMapper implements RowMapper<CategoryDTO>{

	@Override
	public CategoryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CategoryDTO category = new CategoryDTO();
		category.setcID(rs.getInt(1));
		category.setCname(rs.getString(2));
		category.setAmount(rs.getInt(3));
		return category;
	}
	
}
