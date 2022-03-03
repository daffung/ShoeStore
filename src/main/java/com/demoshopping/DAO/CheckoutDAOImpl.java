package com.demoshopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demoshopping.DTO.CartDTO;
import com.demoshopping.entity.Order;
import com.demoshopping.entity.OrderMapper;
import com.demoshopping.entity.VNPayBill;


@Repository
public class CheckoutDAOImpl extends BaseDAO implements ICheckoutDAO{
	
	
	@Override
	@Transactional(rollbackFor = RuntimeException.class)
	public void placeOrder(Order order,HashMap<Long, CartDTO> cart) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO sql_shoppingcart.order (fullname, email, phone, address, city, sub_total, total, payment_method, created_at, updated_at,TxnRef) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatementCreator statementCreator = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				PreparedStatement pStatement = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				pStatement.setString(1, order.getFullname());
				pStatement.setString(2, order.getEmail());
				pStatement.setString(3, order.getPhone());
				pStatement.setString(4, order.getAddress());
				pStatement.setString(5, order.getCity());
				pStatement.setBigDecimal(6, order.getSub_total());;
				pStatement.setBigDecimal(7, order.getTotal());;
				pStatement.setInt(8, order.getPayment_method());
				pStatement.setTimestamp(9, order.getCreated_at());
				pStatement.setTimestamp(10, order.getUpdated_at());
				pStatement.setString(11, order.getTxnRef());
				
				return pStatement;
			}
		};
		try {
			_jdbcTemplate.update(statementCreator, keyHolder);
			if(keyHolder.getKey().longValue() > 0) {
				order.setOrderID(keyHolder.getKey().longValue());
				int[] createOrderDetail = createOrderDetail(order, cart);
				if(!IsCreateDetailSuccessfully(createOrderDetail)) {
					
					throw new RuntimeException();
					
				}
			}
			
		} catch (Exception e) {
			
			throw new RuntimeException();
		}
		// TODO Auto-generated method stub
		
		
	}
	
	@Override
	public Order findOrderByTxnRef(String TxnRef) {
		if(TxnRef.contains("'")) return null;
		String sql = "SELECT * FROM sql_shoppingcart.order WHERE TxnRef = '"+TxnRef+"'";
		
		
		Order order = _jdbcTemplate.queryForObject(sql, new OrderMapper());
		
		return order;
	}
	
	@Override
	@Transactional
	public int saveVNPayBill(VNPayBill bill) {
		
		String sql = "INSERT INTO sql_shoppingcart.vnpay_online_bill (vnp_Amount, vnp_BankCode, vnp_BankTranNo, vnp_CardType, vnp_OrderInfo, vnp_PayDate, vnp_ResponseCode, vnp_TmnCode, vnp_TransactionNo, vnp_TransactionStatus, vnp_TxnRef, confirmCode) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatementCreator statementCreator = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				PreparedStatement pStatement = con.prepareStatement(sql);
				pStatement.setString(1, bill.getVnp_Amount());
				pStatement.setString(2, bill.getVnp_BankCode());
				pStatement.setString(3, bill.getVnp_BankTranNo());
				pStatement.setString(4, bill.getVnp_CardType());
				pStatement.setString(5, bill.getVnp_OrderInfo());
				pStatement.setString(6, bill.getVnp_PayDate());
				pStatement.setString(7, bill.getVnp_ResponseCode());
				pStatement.setString(8, bill.getVnp_TmnCode());
				pStatement.setString(9, bill.getVnp_TransactionNo());
				pStatement.setString(10, bill.getVnp_TransactionStatus());
				pStatement.setString(11, bill.getVnp_TxnRef());
				pStatement.setString(12, bill.getConfirmCode());
				
				//System.out.print("\n"+pStatement.toString()+"\n");
				return pStatement;
			}
		};
		try {
			int result  = _jdbcTemplate.update(statementCreator);
			if(result > 0) {
				return result;
			}else throw new RuntimeException();
			
		} catch (Exception e) {
			
			throw new RuntimeException();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public int[] createOrderDetail(Order order, HashMap<Long, CartDTO> cart) {
		long orderID = order.getOrderID();
		String sql = "INSERT INTO sql_shoppingcart.order_detail (orderID, pID, quantity) VALUES (?,?,?)";
		//System.out.print(orderID);
		
		return batchInsert(sql, new ArrayList<Long>(cart.keySet()), cart, cart.size(), orderID);
	}
	
	
	@Transactional
	public int[] batchInsert(String sql, List<Long> cartKeySetToList,HashMap<Long, CartDTO> cart,int size,long orderID) {
		return _jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Long pID = cartKeySetToList.get(i);
				ps.setLong(1, orderID);
				ps.setLong(2, pID);
				ps.setInt(3, cart.get(pID).getQuantity());
				
			}
			
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return size;
			}
		});
	}
	
	private boolean IsCreateDetailSuccessfully(int[] createDetail) {
		boolean sc = true;
		for (int i:createDetail) {
			if(i<0) sc=false;
		}
		return sc;
	}
	
}
