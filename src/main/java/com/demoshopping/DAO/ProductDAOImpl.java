package com.demoshopping.DAO;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.demoshopping.entity.Product;
import com.demoshopping.entity.ProductMapper;

@Repository
public class ProductDAOImpl  extends BaseDAO implements IProductDAO{
	public static final String price_1 = "0 AND 100";
	public static final String price_2 = "100 AND 140";
	public static final String price_3 = "140 AND 170";
	public static final int limit = 3;

	@Override
	public List<Product> getAllProducts() {
		List<Product> products= new ArrayList<>();
		String sql = "SELECT * FROM sql_shoppingcart.product ORDER BY rand() LIMIT 8;";
		products = _jdbcTemplate.query(sql, new ProductMapper());
		return products;
	}

	@Override
	public List<Product> getNewProducts() {
		List<Product> products= new ArrayList<>();
		String sql = "SELECT * FROM sql_shoppingcart.product ORDER BY `updated_at` DESC LIMIT 4;";
		products = _jdbcTemplate.query(sql, new ProductMapper());
		return products;
	}
	
	@Override
	public List<Product> getProductsByCategory(int cID) {
		List<Product> products= new ArrayList<>();
		String sql = "SELECT * FROM sql_shoppingcart.product WHERE cateID ="+ cID + ";";
		products = _jdbcTemplate.query(sql, new ProductMapper());
		return products;
	}
	@Override
	public List<Product> filterProductsByCategory(int cID, String byPrice, String bySize,int page) {
		StringBuilder sql = new StringBuilder("SELECT * FROM sql_shoppingcart.product WHERE cateID ="+ cID );
		if(byPrice != null) {
			switch (byPrice) {
			case "price-1":
				sql.append(" AND price between "+price_1);
				break;
			case "price-2":
				sql.append(" AND price between "+price_2);
				break;
			case "price-3":
				sql.append(" AND price between "+price_3);
				break;
			default:
				break;
			}
			
		}
		if(page>=1) {
			sql.append(" LIMIT "+limit+" OFFSET "+(page-1)*limit);
		}
		
		//Table does not have Size field
		return _jdbcTemplate.query(sql.toString(), new ProductMapper());
	}
		@Override
		public List<Product> getProductsByCategoryFilteredByPriceAndSize(int cID, String byPrice, String bySize) {
			StringBuilder sql = new StringBuilder("SELECT * FROM sql_shoppingcart.product WHERE cateID ="+ cID );
			if(byPrice != null) {
				switch (byPrice) {
				case "price-1":
					sql.append(" AND price between "+price_1);
					break;
				case "price-2":
					sql.append(" AND price between "+price_2);
					break;
				case "price-3":
					sql.append(" AND price between "+price_3);
					break;
				default:
					break;
				}
				
			}
			//Table does not have Size field
			return _jdbcTemplate.query(sql.toString(), new ProductMapper());
		}
		@Override
		public Product getProductById(long pID) {
			String sql = "SELECT * FROM sql_shoppingcart.product WHERE pID = "+ pID;
			return _jdbcTemplate.queryForObject(sql, new ProductMapper());
		}

}
