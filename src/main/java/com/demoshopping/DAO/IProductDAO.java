package com.demoshopping.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demoshopping.entity.Product;

@Repository
public interface IProductDAO {
	public List<Product> getAllProducts();
	public List<Product> getNewProducts();
	public List<Product> getProductsByCategory(int cID);
	public List<Product> filterProductsByCategory(int cID,String byPrice,String bySize,int page);
	public List<Product> getProductsByCategoryFilteredByPriceAndSize(int cID,String byPrice,String bySize);
	public Product getProductById(long pID);
}
