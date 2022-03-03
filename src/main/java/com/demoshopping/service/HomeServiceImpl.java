package com.demoshopping.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoshopping.DAO.ICategoryDAO;
import com.demoshopping.DAO.IProductDAO;
import com.demoshopping.DTO.CategoryDTO;
import com.demoshopping.entity.Product;


@Service
public class HomeServiceImpl implements IHomeService {
	@Autowired
	public IProductDAO productDAO;
	@Autowired
	public ICategoryDAO categoryDAO;
	
	@Override
	public List<Product> getAllProducts(){
		return productDAO.getAllProducts();
	}
	@Override
	public List<Product> getNewProducts() {
		return productDAO.getNewProducts();
	}
	@Override
	public List<CategoryDTO> getAllCategories() {
		return categoryDAO.getAllCategories();
	}
}
