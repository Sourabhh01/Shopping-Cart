package com.jsp.Shoppingcart.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.Shoppingcart.dao.MerchantDao;
import com.jsp.Shoppingcart.dto.Merchant;

@Controller
public class MerchantController {
	
	@Autowired
	MerchantDao dao;
	
	@RequestMapping("/addmerchant")
	public ModelAndView addMerchant() {
	Merchant m = new Merchant();
	ModelAndView mav = new ModelAndView();
	mav.addObject("merchantob",m);
	mav.setViewName("merchantform");
	return mav;
	}
	
	@RequestMapping("/savemerchant")
	public ModelAndView saveMerchant(@ModelAttribute("merchantob") Merchant m) {
		dao.saveMerchant(m);
		ModelAndView mav = new ModelAndView();
		mav.addObject("message","Data Saved Succesfully");
		mav.setViewName("MenuMerchant");
		return mav;
	}
	
	@RequestMapping("/loginvalidation")
	public ModelAndView login(ServletRequest req,HttpSession session) {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		Merchant m = dao.login(email, pass);
		ModelAndView mav = new ModelAndView();
		if(m!=null) {
			mav.addObject("msg","Successfully Loged in");
			mav.setViewName("merchantoptions");
			session.setAttribute("merchantinfo",m );
			return mav;
		} else {
			mav.addObject("msg","Invalid Creds ");
			mav.setViewName("merchantloginform");
			return mav;
		}
	}
}