package com.hieu.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hieu.bean.Product;
import com.hieu.service.inter.AccountSv;
import com.hieu.service.inter.ProductDetailSv;
import com.hieu.service.inter.ProductSv;

@Controller
public class AllProductController {
	
	@Autowired
	private ProductSv productSv;
	
	@Autowired
	private ProductDetailSv productDetailSv;
	
	@Autowired
	private AccountSv accountSv;
	
	@RequestMapping(value = "/admin/listproduct", method = RequestMethod.GET)
	public ModelAndView listproduct(Model model,HttpServletResponse respon, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("USER_NAME") !=null && accountSv.CheckRoleAdmin((String)session.getAttribute("USER_NAME"))) {
		ModelAndView modelAndView = new ModelAndView("admin/listProduct");
			model.addAttribute("productdetail", productDetailSv.getListProductDetail());
			System.out.println( productDetailSv.getListProductDetail());
		return modelAndView;
		}
		else {
			try {
				respon.sendRedirect("/shopvnua/login");
			} catch (IOException e) {
				
			}
			return null;
		}
	}
	
	@RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id", required = false) int id,HttpServletResponse respon, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("USER_NAME") !=null && accountSv.CheckRoleAdmin((String)session.getAttribute("USER_NAME"))) {
			try {
				productDetailSv.delete(id);
				return "redirect:listproduct";
			} catch (Exception e) {
				return "redirect:/shopvnua/error";
			}
		}
		else {
			return "redirect:/shopvnua/login";
		}
	}
}
