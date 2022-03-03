package com.demoshopping.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demoshopping.DTO.CartDTO;
import com.demoshopping.entity.Product;

@Repository
public class CartDAOImpl implements ICartDAO{
	@Autowired
	public IProductDAO productDAO;

	@Override
	public HashMap<Long, CartDTO> addCart(long pID,int quantity, HashMap<Long, CartDTO> cart) {
		CartDTO item = new CartDTO();
		Product product = productDAO.getProductById(pID);
		if(product == null) return cart;
		if(product != null && cart.containsKey(Long.valueOf(pID))) {
			item = cart.get(pID);
			item.setQuantity(item.getQuantity()+quantity);
			
		}
		else {
			item.setProduct(product);
			item.setQuantity(quantity);
		}
		cart.put(pID, item);
		return cart;
	}

	@Override
	public HashMap<Long, CartDTO> editAndSaveCart(Map<Long, Integer> cartWithIdAndQuantity,
			HashMap<Long, CartDTO> cart) {
		if(cartWithIdAndQuantity == null || cart ==null) return cart;
	Map<Long,CartDTO> cartMap = cart.entrySet().stream()
			.filter(entry->cartWithIdAndQuantity.containsKey(entry.getKey()))
			.collect(Collectors.toMap(entry->entry.getKey(), entry->entry.getValue()));
		for (Long pID:cartMap.keySet()) {
				 CartDTO item = cartMap.get(pID);
					item.setQuantity(cartWithIdAndQuantity.get(pID));
					cartMap.put(pID, item);	
		}
		return (HashMap<Long, CartDTO>)cartMap;
	}



}
