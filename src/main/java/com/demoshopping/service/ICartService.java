package com.demoshopping.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.demoshopping.DTO.CartDTO;

@Service
public interface ICartService {
	public HashMap<Long, CartDTO> addCart(long pID,int quantity,HashMap<Long, CartDTO> cart);
	public HashMap<Long, CartDTO> editAndSaveCart(Map<Long, Integer> cartWithIdAndQuantity,HashMap<Long, CartDTO> cart);
	//public HashMap<Long, CartDTO> deleteCart(long pID,HashMap<Long, CartDTO> cart);
	
}
