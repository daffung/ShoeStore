package com.demoshopping.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demoshopping.entity.Product;
import com.demoshopping.service.IHomeService;

@Controller
public class IndexController extends BaseController {
	@Autowired
	public IHomeService homeService;
	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView Index() {

		List<Product> products = homeService.getAllProducts();
		List<Product> newProducts = homeService.getNewProducts();
		//System.out.print(newProducts.get(0).getUpdated_at());
		_modelAndView.addObject("products", products);
		_modelAndView.addObject("new_products", newProducts);
		_modelAndView.setViewName("index");
		return _modelAndView;
	}
	@RequestMapping("/shop")
	public String Shop(HttpSession session,Model model) {
		//System.out.print(session.getAttribute("login_account"));
		//mv.setViewName("shop");
		model.addAttribute("status", "Đặt hàng thành công");
		return "shop";
	}
	@RequestMapping("/detail")
	public ModelAndView Detail() {

		_modelAndView.setViewName("detail");
		return _modelAndView;
	}
//	@RequestMapping("/cart")
//	public ModelAndView Cart() {
//
//		_modelAndView.setViewName("cart");
//		return _modelAndView;
//	}
//	@RequestMapping("/payment")
//	public ModelAndView Payment() {
//
//		_modelAndView.setViewName("payment");
//		return _modelAndView;
//	}
}
