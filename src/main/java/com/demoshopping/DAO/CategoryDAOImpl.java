package com.demoshopping.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.demoshopping.DTO.CategoryDTO;
import com.demoshopping.DTO.CategoryDTOMapper;



@Repository
public class CategoryDAOImpl extends BaseDAO implements ICategoryDAO{

	@Override
	public List<CategoryDTO> getAllCategories() {
		List<CategoryDTO> categories = new ArrayList<>();
		String sql = "SELECT cID, "
					+ "		cname,"
					+ "		count(pID) AS amount "
					+ "FROM sql_shoppingcart.category AS c "
					+ "JOIN sql_shoppingcart.product AS p "
					+ "ON c.cID = p.cateID "
					+ "GROUP BY cID;";
		categories = _jdbcTemplate.query(sql, new CategoryDTOMapper());
		return categories;
	}
	
}
