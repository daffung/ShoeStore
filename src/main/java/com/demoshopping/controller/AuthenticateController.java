package com.demoshopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.DefaultEventListenerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demoshopping.entity.Account;
import com.demoshopping.service.IAuthenticateService;


@Controller
public class AuthenticateController extends BaseController{
	@Autowired
	public IAuthenticateService authenticateService;
	
	@GetMapping("/register")
	public ModelAndView Register() {
		_modelAndView.setViewName("register");
		Account account = new Account();
		_modelAndView.addObject("account", account);
		return _modelAndView;
	}
	@PostMapping("/register")
	public ModelAndView CreateAccount(@ModelAttribute("account") Account account,HttpServletRequest req ) {
		String repeatPassword = req.getParameter("repeat_password");
		int count = 0;
		if(repeatPassword.equals(account.getPassword())) {
			count = authenticateService.createAccount(account);
		} 
		String status = null;
		_modelAndView.setViewName("message_register");
		if(count>0) {
			status = "Đăng ký thành công";
			
		}
		else if (count == -1) {
			status = "Tài khoản đã đăng ký";
			
		}
		else{
			status = "Đăng ký thất bại";
		}
		System.out.print(account);
		_modelAndView.addObject("status",status);
		return _modelAndView;
	}
	@GetMapping("/login")
	public ModelAndView Login() {
		_modelAndView.clear();
		_modelAndView.setViewName("login");
		Account account = new Account();
		
		_modelAndView.addObject("account", account);
		return _modelAndView;
	}
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("account") Account account,HttpSession session) {
		Account authenticatedAccount = authenticateService.authenticateAccount(account);
		if(authenticatedAccount != null) {
			_modelAndView.setViewName("redirect:/");
			//System.out.print(authenticatedAccount);
			session.setAttribute("login_account", authenticatedAccount);
			return _modelAndView;
		}
		else {
			_modelAndView.setViewName("login");
			_modelAndView.addObject("login_status", "Sai mật khẩu hoặc email");
			return _modelAndView;
		}
	}
}
