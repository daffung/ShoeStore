package com.demoshopping.DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.demoshopping.DTO.CartDTO;

@Repository
public interface ICartDAO {
	public HashMap<Long, CartDTO> addCart(long pID,int quantity,HashMap<Long, CartDTO> cart);
	public HashMap<Long, CartDTO> editAndSaveCart(Map<Long, Integer> cartWithIdAndQuantity,HashMap<Long, CartDTO> cart);
	//public HashMap<Long, CartDTO> deleteCart(long pID,HashMap<Long, CartDTO> cart);
}
