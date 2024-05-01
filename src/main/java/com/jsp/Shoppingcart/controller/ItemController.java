package com.jsp.Shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.Shoppingcart.dao.CartDao;
import com.jsp.Shoppingcart.dao.CustomerDao;
import com.jsp.Shoppingcart.dao.ItemDao;
import com.jsp.Shoppingcart.dao.ProductDao;
import com.jsp.Shoppingcart.dto.Cart;
import com.jsp.Shoppingcart.dto.Customer;
import com.jsp.Shoppingcart.dto.Item;
import com.jsp.Shoppingcart.dto.Product;

@Controller
public class ItemController {
	@Autowired
	ItemDao idao;
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	CartDao cdao;
	
	@Autowired
	CustomerDao cusDao;

	@RequestMapping("/additem")
	public ModelAndView addItem(@RequestParam("id")int id) {
		Product p = pdao.findProductbyid(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("prodobj",p);
		mav.setViewName("itemform");
		return mav;
	}
	@RequestMapping("/additemtocart")
	public ModelAndView addItemtocart(ServletRequest req,HttpSession session) {
		int prod_id = Integer.parseInt(req.getParameter("id"));
		String brand = req.getParameter("brand");
		double price = Double.parseDouble(req.getParameter("price")); 
		String model = req.getParameter("model");
		String category = req.getParameter("category");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		Item item = new Item();
		item.setBrand(brand);
		item.setCategory(category);
		item.setModel(model);
		item.setP_id(prod_id);
		item.setPrice(price);
		item.setQuantity(quantity);
		
		Customer cust = (Customer) session.getAttribute("customerinfo");
		Cart c = cust.getCart();
		if(c==null) {
			Cart cart = new Cart();
			List<Item> items = new ArrayList<Item>();
			items.add(item);
			cart.setItems(items);
			cart.setName(cust.getName());
			
			cart.setTotalPrice(item.getPrice());
			cust.setCart(cart);
			idao.saveItem(item);
			cdao.saveCart(cart);
			cusDao.updateCustomer(cust);
		}
		else {
			List<Item> items = c.getItems();
			if(items !=null) {
				items.add(item);
				c.setItems(items);
				double totalprice = 0.0;
				for(Item i :items)
					totalprice = totalprice + i.getPrice();
				
					c.setTotalPrice(totalprice);
					cust.setCart(c);
					idao.saveItem(item);
					cdao.updateCart(c);
					cusDao.updateCustomer(cust);	
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect://displayproducts");
		return mav;
	}
}
