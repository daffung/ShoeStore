package com.demoshopping.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.demoshopping.service.IHomeService;

@Controller
public class BaseController {
	@Autowired
	public IHomeService homeService;
	
	public ModelAndView _modelAndView = new ModelAndView();
	
	
	
	@PostConstruct
	public ModelAndView shareModelAndView() {
		
		_modelAndView.addObject("categories",homeService.getAllCategories());
		return _modelAndView;
	}
}
