package com.demoshopping.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demoshopping.DTO.CategoryDTO;


@Repository
public interface ICategoryDAO {
	 public List<CategoryDTO> getAllCategories();
	 
}
