package com.jsp.Shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.Shoppingcart.dao.MerchantDao;
import com.jsp.Shoppingcart.dao.ProductDao;
import com.jsp.Shoppingcart.dto.Merchant;
import com.jsp.Shoppingcart.dto.Product;

@Controller
public class ProductController {

	@Autowired
	ProductDao dao;
	
	@Autowired
	MerchantDao mdao;
	
	@RequestMapping("/addproduct")
	public ModelAndView addProduct() {
		Product p = new Product();
		ModelAndView mav = new ModelAndView();
		mav.addObject("productobj", p);
		mav.setViewName("productform");
		return mav;
	}
	
	@RequestMapping("/saveproduct")
	public ModelAndView saveProduct(@ModelAttribute("productobj" )Product p,HttpSession session){
		Merchant m = (Merchant) session.getAttribute("merchantinfo");
		List<Product> products = m.getProducts();
		if(products !=null) {
			products.add(p);
			m.setProducts(products);
		}
		else {
			List<Product> productslist = new ArrayList<Product>();
			productslist.add(p);
			m.setProducts(productslist);
		}
		dao.saveProduct(p);
		mdao.updateMerchant(m);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","Data Saved Successfully");
		mav.setViewName("merchantoptions");
		return mav;
	}
	@RequestMapping("/deleteproduct")
	public ModelAndView deleteProduct(@RequestParam("id") int id,HttpSession session) {
		Merchant merchant  =  (Merchant) session.getAttribute("merchantinfo");
		Merchant m = mdao.deleteProductFromMerchant(merchant.getEmail(),id);
		
		mdao.updateMerchant(m);
		dao.deletebyId(id);
		
		session.setAttribute("merchantinfo", m);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewallproduct");
		return mav;
	}
	@RequestMapping("/displayproducts")
	public ModelAndView displayProduct() {
		List<Product> products = dao.findAllProduct();
		ModelAndView mav = new ModelAndView();
		mav.addObject("productslist",products);
		mav.setViewName("viewallproducttocustomer");
		return mav;
	}
	@RequestMapping("/displayproductbybrand")
	public ModelAndView displaybyBrand(ServletRequest req) {
		
		String brand = req.getParameter("brand");
		List<Product> products = dao.findproductbybrand(brand);
		ModelAndView mav = new ModelAndView();
		mav.addObject("productslist",products);
		mav.setViewName("viewallproducttocustomer");
		return mav;
	}
	@RequestMapping("/displayproductbycategory")
	public ModelAndView displaybyCategory(ServletRequest req) {
		
		String category = req.getParameter("category");
		List<Product> products = dao.findproductbyCategory(category);
		ModelAndView mav = new ModelAndView();
		mav.addObject("productslist",products);
		mav.setViewName("viewallproducttocustomer");
		return mav;
	}
	@RequestMapping("/displayproductbymodel")
	public ModelAndView displaybymodel(ServletRequest req) {
		
		String model = req.getParameter("model");
		List<Product> products = dao.findproductbymodel(model);
		ModelAndView mav = new ModelAndView();
		mav.addObject("productslist",products);
		mav.setViewName("viewallproducttocustomer");
		return mav;
	}
}
