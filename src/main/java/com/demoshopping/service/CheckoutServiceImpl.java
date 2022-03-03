package com.demoshopping.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoshopping.DAO.ICheckoutDAO;
import com.demoshopping.DTO.CartDTO;
import com.demoshopping.entity.Order;
import com.demoshopping.entity.VNPayBill;

@Service
public class CheckoutServiceImpl implements ICheckoutService{
	
	@Autowired
	public ICheckoutDAO checkoutDAO;
	
	
		@Override
		public void  placeOrder(Order order,HashMap<Long, CartDTO> cart) {
			// TODO Auto-generated method stub
			checkoutDAO.placeOrder(order,cart);
		}
		
		@Override
		public int saveVNPayBill(VNPayBill bill) {
			// TODO Auto-generated method stub
			return checkoutDAO.saveVNPayBill(bill);
		}
		
		@Override
		public Order findOrderByTxnRef(String TxnRef) {
			// TODO Auto-generated method stub
			return checkoutDAO.findOrderByTxnRef(TxnRef);
		}
}
