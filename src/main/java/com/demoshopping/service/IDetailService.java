package com.demoshopping.service;

import org.springframework.stereotype.Service;

import com.demoshopping.entity.Product;

@Service
public interface IDetailService {
	public Product getProductById(long pID);
}
