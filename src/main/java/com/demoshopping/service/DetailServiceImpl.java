package com.demoshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoshopping.DAO.IProductDAO;
import com.demoshopping.entity.Product;

@Service
public class DetailServiceImpl implements IDetailService{
	@Autowired
	public IProductDAO productDAO;
	
	@Override
	public Product getProductById(long pID) {
		
		return productDAO.getProductById(pID);
	}
}
