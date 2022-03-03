package com.demoshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.demoshopping.DAO.IProductDAO;
import com.demoshopping.entity.Product;

@Service
public class CategoriesServiceImpl implements ICategoriesService{
	
	@Autowired
	public IProductDAO productDAO;
	
	
	@Override
	public List<Product> getProductsByCategory(int cID) {
		return productDAO.getProductsByCategory(cID);
	}
	@Override
	public List<Product> filterProductsByCategory(int cID, String byPrice, String bySize,int page) {
		return productDAO.filterProductsByCategory(cID, byPrice, bySize,page);
	}
}
