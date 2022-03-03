package com.demoshopping.DAO;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.demoshopping.DTO.CartDTO;
import com.demoshopping.entity.Order;
import com.demoshopping.entity.VNPayBill;

@Repository
public interface ICheckoutDAO {
	public void placeOrder(Order order,HashMap<Long, CartDTO> cart);
	public int saveVNPayBill(VNPayBill bill);
	public Order findOrderByTxnRef(String TxnRef);
	
}
