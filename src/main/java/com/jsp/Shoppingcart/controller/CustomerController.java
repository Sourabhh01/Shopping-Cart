package com.jsp.Shoppingcart.controller;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.Shoppingcart.dao.CustomerDao;
import com.jsp.Shoppingcart.dao.MerchantDao;
import com.jsp.Shoppingcart.dto.Customer;

@Controller
public class CustomerController {
		@Autowired
	CustomerDao dao;
	@RequestMapping("/addcustomer")
	public ModelAndView addCustomer() {
	Customer c = new Customer();
	ModelAndView mav = new ModelAndView();
	mav.addObject("customerob",c);
	mav.setViewName("Customerform");
	return mav;
	}
	
	@RequestMapping("/savecustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customerob") Customer c) {
		dao.saveCustomer(c);
		ModelAndView mav = new ModelAndView();
		mav.addObject("message","Data Saved Succesfully");
		mav.setViewName("CustomerMenu");
		return mav;
	}
	@RequestMapping("/customerlogin")
	public ModelAndView login(ServletRequest req,HttpSession session) {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		Customer c = dao.login(email, pass);
		ModelAndView mav = new ModelAndView();
		if(c!=null) {
			mav.addObject("msg","Successfully Loged in");
			mav.setViewName("customeroptions");
			session.setAttribute("customerinfo",c );
			return mav;
		} else {
			mav.addObject("msg","Invalid Creds ");
			mav.setViewName("customerloginform");
			return mav;
		}
	}
}
