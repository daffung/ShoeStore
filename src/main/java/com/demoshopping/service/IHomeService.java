package com.demoshopping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demoshopping.DTO.CategoryDTO;
import com.demoshopping.entity.Product;
@Service
public interface IHomeService {
	public List<Product> getAllProducts();
	public List<Product> getNewProducts();
	public List<CategoryDTO> getAllCategories();
}
