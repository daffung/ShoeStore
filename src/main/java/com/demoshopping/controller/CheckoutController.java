package com.demoshopping.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demoshopping.DTO.CartDTO;
import com.demoshopping.config.VnpConfig;
import com.demoshopping.entity.Order;
import com.demoshopping.entity.VNPayBill;
import com.demoshopping.service.ICheckoutService;



@Controller
public class CheckoutController extends BaseController{
	
	@Autowired
	public ICheckoutService checkoutService;
	
	@RequestMapping("/checkout")
	public ModelAndView Checkout(HttpSession session) {
		_modelAndView.setViewName("checkout");
		
			_modelAndView.addObject("order", new Order());
		
		
		return _modelAndView;
	}
	
	
	@PostMapping("/place_order")
	public String PlaceOrder(@ModelAttribute("order") Order order,HttpSession session,HttpServletRequest req, HttpServletResponse resp,Model model){
		@SuppressWarnings("unchecked")
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("cart");
		
		if(cart==null || cart.size()==0) return "Do nothing";
		long currentTimeInMillis = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(currentTimeInMillis);
		order.setCreated_at(timestamp);
		order.setUpdated_at(timestamp);
		
		try {
			
			String txnRef = VnpConfig.getRandomNumber(12);
			order.setTxnRef(txnRef);
			String payURL = createVNPay_URL(req, resp, "2.1.0", "pay", txnRef, order, currentTimeInMillis);
			checkoutService.placeOrder(order,cart);
			if(order.getPayment_method() == 3) {
				System.out.print("\nSuccess to place order:"+(long)(order.getTotal().floatValue()*20000) * 100+"\n"+payURL);
				
				return "redirect:"+payURL;
			}else {
				model.addAttribute("status", "Đặt hàng thành công");
				return "message_register";
			}
			
		} catch (Exception e) {
			System.out.print('\n'+"Failed to place order");
			return "redirect:"+req.getHeader("Referer");
		}
		
		
		
	}
	

	
	@GetMapping("/payment_result")
	public ModelAndView DisplayPaymentResult(
			@RequestParam("vnp_Amount") String vnp_Amount,
			@RequestParam("vnp_BankCode") String vnp_BankCode,
			@RequestParam("vnp_BankTranNo") String vnp_BankTranNo,
			@RequestParam("vnp_CardType") String vnp_CardType,
			@RequestParam("vnp_OrderInfo") String vnp_OrderInfo,
			@RequestParam("vnp_PayDate") String vnp_PayDate,
			@RequestParam("vnp_ResponseCode") String vnp_ResponseCode,
			@RequestParam("vnp_TmnCode") String vnp_TmnCode,
			@RequestParam("vnp_TransactionNo") String vnp_TransactionNo,
			@RequestParam("vnp_TransactionStatus") String vnp_TransactionStatus,
			@RequestParam("vnp_TxnRef") String vnp_TxnRef,
			@RequestParam("vnp_SecureHash") String vnp_SecureHash,
			HttpServletRequest req,HttpServletResponse res) throws ParseException {
		//_modelAndView.clear();
		_modelAndView.setViewName("payment");
		VNPayBill bill = new VNPayBill();
        bill.setVnp_Amount(vnp_Amount);
        bill.setVnp_BankCode(vnp_BankCode);
        bill.setVnp_BankTranNo(vnp_BankTranNo);
        bill.setVnp_CardType(vnp_CardType);
        bill.setVnp_OrderInfo(vnp_OrderInfo);
        bill.setVnp_PayDate(vnp_PayDate);
        bill.setVnp_ResponseCode(vnp_ResponseCode);
        bill.setVnp_TmnCode(vnp_TmnCode);
        bill.setVnp_TransactionNo(vnp_TransactionNo);
        bill.setVnp_TransactionStatus(vnp_TransactionStatus);
        bill.setVnp_TxnRef(vnp_TxnRef);
		try {
			Map<String,String> fields = new HashMap<String,String>();
	         for (Enumeration<String> params = req.getParameterNames(); params.hasMoreElements();) {
	             String fieldName = (String) params.nextElement();
	             String fieldValue = req.getParameter(fieldName);
	             if ((fieldValue != null) && (fieldValue.length() > 0)) {
	                 fields.put(fieldName, fieldValue);
	             }
	         }

	         if (fields.containsKey("vnp_SecureHashType")) {
	             fields.remove("vnp_SecureHashType");
	         }
	         if (fields.containsKey("vnp_SecureHash")) {
	             fields.remove("vnp_SecureHash");
	         }
	         String signValue = VnpConfig.hashAllFields(fields);
	        // System.out.print("\n"+signValue+"\n"+fields.toString());
	         _modelAndView.addObject("vnp_Amount",Long.valueOf(vnp_Amount)/100);
	         _modelAndView.addObject("vnp_BankCode",vnp_BankCode);
	         _modelAndView.addObject("vnp_BankTranNo",vnp_BankTranNo);
	         _modelAndView.addObject("vnp_CardType",vnp_CardType);
	         _modelAndView.addObject("vnp_OrderInfo",vnp_OrderInfo);
	         _modelAndView.addObject("vnp_PayDate",new SimpleDateFormat("yyyyMMddHHmmss").parse(vnp_PayDate).toString() );
	         _modelAndView.addObject("vnp_ResponseCode",vnp_ResponseCode);
//	         _modelAndView.addObject("vnp_TmnCode",vnp_TmnCode);
	         _modelAndView.addObject("vnp_TransactionNo",vnp_TransactionNo);
	         _modelAndView.addObject("vnp_TransactionStatus",vnp_TransactionStatus);
	         _modelAndView.addObject("vnp_TxnRef",vnp_TxnRef);
	         
	         
			if (signValue.equals(vnp_SecureHash)) {
				
	            boolean checkOrderId = true; // vnp_TxnRef exists in your database
	            
	            Order order = checkoutService.findOrderByTxnRef(vnp_TxnRef);
	              if (order == null) checkOrderId = false;

	             
	           
	            boolean checkAmount = true; // vnp_Amount is valid (Check vnp_Amount VNPAY returns compared to the amount of the code (vnp_TxnRef) in the Your database). 
	            if(Long.parseLong(vnp_Amount) != (long)(order.getTotal().floatValue()*20000) * 100) checkAmount = false;
	            
	            boolean checkOrderStatus = true; // PaymnentStatus = 0 (pending)
				if(!"00".equals(vnp_TransactionStatus)) checkOrderStatus=false;
				
	            if(checkOrderId)
	            {
	                if(checkAmount)
	                {
	                    if (checkOrderStatus)
	                    {
	                        if ("00".equals(req.getParameter("vnp_ResponseCode")))
	                        {
	                        	bill.setConfirmCode("00");
		        	        	_modelAndView.addObject("message","Giao dịch thành công");
	                            //Here Code update PaymnentStatus = 1 into your Database
	                        }
	                        else
	                        {
	                        	bill.setConfirmCode("00");
		        	        	_modelAndView.addObject("message","Giao dịch thất bại");
	                            // Here Code update PaymnentStatus = 2 into your Database
	                        }
	                        
	                    }
	                    else
	                    {
	                        
	                    	bill.setConfirmCode("02");
	        	        	_modelAndView.addObject("message","Giao dịch thất bại");
	                    }
	                }
	                else
	                {
	                	bill.setConfirmCode("04");
	    	        	_modelAndView.addObject("message","Invalid Amount");
	                }
	            }
	            else
	            {
	            	bill.setConfirmCode("01");
		        	_modelAndView.addObject("message","Order not found");
	            }
	         

	        } else {
	        	
	        	bill.setConfirmCode("97");
	        	_modelAndView.addObject("message","Chữ ký không hợp lệ");
	        }
		} catch (Exception e) {
			bill.setConfirmCode("99");
			_modelAndView.addObject("message","Unknown Error");
		}
		try {
			int save = checkoutService.saveVNPayBill(bill);
			if(save <=0 ) throw new RuntimeException();
		} catch (Exception e) {
			_modelAndView.addObject("message","Không lưu được hóa đơn");
		}
		
		
		
		return _modelAndView;
	}
	
	
	public String createVNPay_URL(HttpServletRequest req, HttpServletResponse resp,
			String vnp_Version,String vnp_Command,String TxnRef,Order order,long currentTimeMillis) throws UnsupportedEncodingException {
//		String vnp_Version = "2.1.0";
//        String vnp_Command = "pay";
        String vnp_OrderInfo = "Eshop-Thanh toan giay "+TxnRef;//
        String orderType = VnpConfig.orderType;
        String vnp_TxnRef = TxnRef;
        String vnp_IpAddr = VnpConfig.getIpAddress(req);
        String vnp_TmnCode = VnpConfig.vnp_TmnCode;
        //System.out.print(req.getParameter("amount"));
        long amount = (long)(order.getTotal().floatValue()*20000) * 100;//
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");
        String bank_code = req.getParameter("bankcode");// khong can thiet
        if (bank_code != null && !bank_code.isEmpty()) {
            vnp_Params.put("vnp_BankCode", bank_code);
        }
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo);
        vnp_Params.put("vnp_OrderType", orderType);

        String locate = req.getParameter("language");
        if (locate != null && !locate.isEmpty()) {
            vnp_Params.put("vnp_Locale", locate);
        } else {
            vnp_Params.put("vnp_Locale", "vn");
        }
        vnp_Params.put("vnp_ReturnUrl", VnpConfig.vnp_Returnurl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
        Calendar cld = Calendar.getInstance();
        cld.setTimeInMillis(currentTimeMillis);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());

        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        //Add Params of 2.0.1 Version
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
        
        //Build data to hash and querystring
        List<String> fieldNames = new ArrayList<>(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator<String> itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = VnpConfig.hmacSHA512(VnpConfig.vnp_HashSecret, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = VnpConfig.vnp_PayUrl + "?" + queryUrl;

//        JsonObject job = new JsonObject();
//        job.addProperty("code", "00");
//        job.addProperty("message", "success");
//        job.addProperty("data", paymentUrl);
//        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        
        return paymentUrl;
	}
	
}
