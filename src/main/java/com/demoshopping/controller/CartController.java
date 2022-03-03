package com.demoshopping.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demoshopping.DTO.CartDTO;

import com.demoshopping.service.ICartService;

@Controller
class CartController extends BaseController{
	@Autowired
	public ICartService cartService;

	@RequestMapping("/cart")
	public ModelAndView getCart(HttpServletRequest req) {
		//get all cart here
		_modelAndView.setViewName("cart");
		return _modelAndView;
		
	}
	

	@SuppressWarnings("unchecked")
	@PostMapping("/addToCart")
	@ResponseBody
	public String addToCart(HttpServletRequest req,HttpSession session) {
		//add to cart here
		long pID = Long.parseLong(req.getParameter("pID"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("cart");

		if(cart == null) {
			cart = new HashMap<Long, CartDTO>();

		}

		cart = cartService.addCart(pID,quantity,cart);
		System.out.println(cart.keySet());
		session.setAttribute("cart", cart);
		//session.setAttribute("total_cart", cart.size());
		return "Add successfully, Cart size: "+cart.size();
	}
	@SuppressWarnings("unchecked")
	@PostMapping("/editAndSaveCart")
	@ResponseBody
	public String editAndSaveCart(@RequestParam Map<String, String> cartString,HttpSession session) {
		//edit or delete and save cart here
		Map<Long, Integer> cartWithIdAndQuantity = new HashMap<Long, Integer>(cartString.size());
		for (String pID:cartString.keySet()) {
			cartWithIdAndQuantity.put(Long.valueOf(pID), Integer.valueOf(cartString.get(pID)));
		}
		
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		
			cart = cartService.editAndSaveCart(cartWithIdAndQuantity,cart);
			 
			//System.out.print(cart.values());
		session.setAttribute("cart", cart);

		return "Save cart successfully, Cart size: "+cart.size();
	}
	
	
	
}
