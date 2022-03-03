package com.demoshopping.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoshopping.DAO.ICartDAO;
import com.demoshopping.DTO.CartDTO;

@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	public ICartDAO cartDAO;

	@Override
	public HashMap<Long, CartDTO> addCart(long pID,int quantity, HashMap<Long, CartDTO> cart) {
		// TODO Auto-generated method stub
		return cartDAO.addCart(pID,quantity, cart);
	}

	@Override
	public HashMap<Long, CartDTO> editAndSaveCart(Map<Long, Integer> cartWithIdAndQuantity,HashMap<Long, CartDTO> cart) {
		// TODO Auto-generated method stub
		return cartDAO.editAndSaveCart(cartWithIdAndQuantity, cart);
	}


}
