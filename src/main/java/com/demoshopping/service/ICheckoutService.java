package com.demoshopping.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.demoshopping.DTO.CartDTO;
import com.demoshopping.entity.Order;
import com.demoshopping.entity.VNPayBill;

@Service
public interface ICheckoutService {
	public void  placeOrder(Order order,HashMap<Long, CartDTO> cart);
	public int saveVNPayBill(VNPayBill bill);
	public Order findOrderByTxnRef(String TxnRef);
}
