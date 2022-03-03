package com.demoshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demoshopping.service.IDetailService;
import com.demoshopping.service.IHomeService;

@Controller
public class DetailController extends BaseController{
	@Autowired
	public IDetailService detailService;
	@Autowired
	public IHomeService homeService;
	
	
	@RequestMapping(value={"/detail/{pID}"})
	public ModelAndView Detail(@PathVariable long pID) {
		// fetch product detail here
		_modelAndView.addObject("product", detailService.getProductById(pID));
		_modelAndView.addObject("new_products", homeService.getNewProducts());
		_modelAndView.addObject("pID",pID);
		_modelAndView.setViewName("detail");
		return _modelAndView;
	}
	
}
