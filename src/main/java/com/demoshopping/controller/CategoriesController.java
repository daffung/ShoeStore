package com.demoshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.demoshopping.DTO.PaginationDTO;
import com.demoshopping.service.ICategoriesService;
import com.demoshopping.service.IPaginateService;

@Controller
public class CategoriesController extends BaseController {

	static final int limitOfPages = 3;

	@Autowired
	public ICategoriesService categoriesService;
	@Autowired
	public IPaginateService paginateService;

	@RequestMapping("/categories/{cID}")
	public ModelAndView Categories(@PathVariable int cID,
			@RequestParam(value = "byPrice", required = false, defaultValue = "price-all") String byPrice,
			@RequestParam(value = "bySize", required = false, defaultValue = "size-all") String bySize,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		if (page < 1)
			page = 1;
		PaginationDTO pDto = paginateService.getPaginationInfoByCategory(cID,byPrice, bySize, page, limitOfPages);


		_modelAndView.setViewName("shop");
		_modelAndView.addObject("cID", cID);
		_modelAndView.addObject("byPrice", byPrice);
		_modelAndView.addObject("bySize", bySize);
		_modelAndView.addObject("paginationDTO", pDto);
		_modelAndView.addObject("productsByCategory",
				categoriesService.filterProductsByCategory(cID, byPrice, bySize, pDto.currentPage));
		return _modelAndView;
	}

	@RequestMapping("/categories/{cID}/filter/")

	public ModelAndView FilterCategories(@PathVariable int cID,
			@RequestParam(value = "byPrice", required = false, defaultValue = "price-all") String byPrice,
			@RequestParam(value = "bySize", required = false, defaultValue = "size-all") String bySize,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		if (page < 1)
			page = 1;
		PaginationDTO pDto = paginateService.getPaginationInfoByCategory(cID, byPrice, bySize,page, limitOfPages);

		System.out.print(pDto);
		_modelAndView.setViewName("shop");
		_modelAndView.addObject("cID", cID);
		_modelAndView.addObject("byPrice", byPrice);
		_modelAndView.addObject("bySize", bySize);
		_modelAndView.addObject("paginationDTO", pDto);
		_modelAndView.addObject("productsByCategory",
				categoriesService.filterProductsByCategory(cID, byPrice, bySize, pDto.currentPage));
		return _modelAndView;
	}
}
