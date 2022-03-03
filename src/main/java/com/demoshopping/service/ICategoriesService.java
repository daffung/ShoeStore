package com.demoshopping.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.demoshopping.entity.Product;

@Service
public interface ICategoriesService {
	public List<Product> getProductsByCategory(int cID);
	public List<Product> filterProductsByCategory(int cID,String byPrice,String bySize,int page);
}
