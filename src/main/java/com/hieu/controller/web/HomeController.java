package com.hieu.controller.web;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.hieu.bean.Cart;
import com.hieu.bean.Product;
import com.hieu.bean.ProductDetail;
import com.hieu.service.inter.ProductDetailSv;
import com.mysql.fabric.xmlrpc.base.Array;


@Controller(value = "homeOfWeb")
public class HomeController {

	@Autowired
	private ProductDetailSv productDetailSv;
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView home1(ModelMap model, @RequestParam(value = "page", required = false) String number) {
		ModelAndView modelAndView = new ModelAndView("web/home");
			if (number == null) {
				model.put("listproductdetail", productDetailSv.getListProductDetails(1,""));
			}
			else {
				model.put("listproductdetail", productDetailSv.getListProductDetails(Integer.valueOf(number),""));
			}
			List<Integer> numberOfPage = new ArrayList<Integer>();
			for (int i=1; i<=productDetailSv.getNumberOfPage("no"); i++) {
				numberOfPage.add(i);
			}
			model.put("numberPage",numberOfPage);
		return modelAndView;
	}
	
	@RequestMapping(value = "/trang-chu1", method = RequestMethod.GET)
	public ModelAndView hometest(ModelMap model, HttpServletResponse respon) {
		ModelAndView modelAndView = new ModelAndView("web/home1");
			
		return modelAndView;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam(name="searchbox", required = false) String searchbox, ModelMap model) {
		ModelAndView modelAndView = new ModelAndView("web/home");
		model.put("listproductdetail", productDetailSv.findListProductDetail(searchbox));
		System.out.println(productDetailSv.findListProductDetail(searchbox));
		return modelAndView;
	}
}
