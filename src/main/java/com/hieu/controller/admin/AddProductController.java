package com.hieu.controller.admin;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hieu.bean.Product;
import com.hieu.bean.ProductDetail;
import com.hieu.service.inter.AccountSv;
import com.hieu.service.inter.CategorySv;
import com.hieu.service.inter.ProductDetailSv;
import com.hieu.service.inter.ProductSv;
import com.hieu.service.inter.TradeMarkSv;

@Controller
public class AddProductController {

	@Autowired
	private CategorySv categorySv;

	@Autowired
	private TradeMarkSv tradeMarkSv;

	@Autowired
	private ProductSv productSv;

	@Autowired
	private ProductDetailSv productDetailSv;

	@Autowired
	private AccountSv accountSv;
	
	@RequestMapping(value = "/admin/addProduct", method = RequestMethod.GET)
	public ModelAndView showViewAddProduct(Model model, HttpServletRequest request, HttpServletResponse respons) throws IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("USER_NAME") !=null && accountSv.checkUserRole((String)session.getAttribute("USER_NAME")) != true) {
		ModelAndView modelAndView = new ModelAndView("admin/addProduct");
		model.addAttribute("category", categorySv.getlistCategories());
		model.addAttribute("trademark", tradeMarkSv.getListTradeMarks());
		model.addAttribute("product", new Product());
		model.addAttribute("productdetail", new ProductDetail());
		model.addAttribute("listproduct", productSv.getListProducts());
		return modelAndView;
		}
		else {
			try {
				respons.sendRedirect("/shopvnua/login");
			} catch (IOException e) {
				
			}
			return null;
		}
		
	}

	@RequestMapping(value = "/admin/addaction", method = RequestMethod.POST)
	public String addAction(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Product product,
			@ModelAttribute ProductDetail prodetail, BindingResult result, ModelMap m, Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("USER_NAME") !=null && accountSv.checkUserRole((String)session.getAttribute("USER_NAME")) != true) {
		try {
			productSv.add(product, Integer.parseInt(request.getParameter("category")),
					Integer.parseInt(request.getParameter("trademark")));
			productDetailSv.addOrUpdate(prodetail, product, (String)session.getAttribute("USER_NAME"));
		} catch (Exception e) {
			
		}
		return "redirect:addProduct";
		}
		else {
			return "redirect:/shopvnua/login";
		}
	}
	
	@RequestMapping(value = "/admin/addedaction", method = RequestMethod.POST)
	public String addedaction(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ProductDetail productDetail) {
		HttpSession session = request.getSession();
		if(session.getAttribute("USER_NAME") !=null && accountSv.checkUserRole((String)session.getAttribute("USER_NAME")) != true) {
			int idProduct = Integer.parseInt(request.getParameter("listproduct"));
			productDetailSv.add(productDetail, idProduct, (String)session.getAttribute("USER_NAME"));
			return "redirect:addProduct";
		}
		else {
			return "redirect:/shopvnua/login";
		}
	}
}
