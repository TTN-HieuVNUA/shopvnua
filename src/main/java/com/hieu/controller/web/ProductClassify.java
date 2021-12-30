package com.hieu.controller.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hieu.service.inter.ProductDetailSv;
import com.hieu.service.inter.ProductSv;

@Controller
public class ProductClassify {

	@Autowired
	private ProductDetailSv productDetailSv;
	
	@RequestMapping(value = "/sanpham/{categoryName}", method = RequestMethod.GET)
	public ModelAndView home4(@PathVariable(value = "categoryName") String categoryName,@RequestParam(value = "page", required = false) String page, Model model) {
		ModelAndView modelAndView = new ModelAndView("web/productPortfolio");
		ArrayList<Integer> ListNumber = new ArrayList<Integer>();
			if (categoryName.equalsIgnoreCase("nam")) {
				model.addAttribute("name", "Đồ Nam");
				if (page==null) {
					model.addAttribute("listproduct", productDetailSv.getListProductDetails(1, "nam"));
				}
				else {
					model.addAttribute("listproduct", productDetailSv.getListProductDetails(Integer.valueOf(page), "nam"));
				}
				for (int i = 1; i <= productDetailSv.getNumberOfPage("nam"); i++) {
					ListNumber.add(i);
				}
			} else if (categoryName.equalsIgnoreCase("nu")) {
				model.addAttribute("name", "Đồ Nữ");
				if (page==null) {
					model.addAttribute("listproduct", productDetailSv.getListProductDetails(1, "nữ"));
				}
				else {
					model.addAttribute("listproduct", productDetailSv.getListProductDetails(Integer.valueOf(page), "nữ"));
				}
				for (int i = 1; i <= productDetailSv.getNumberOfPage("nữ"); i++) {
					ListNumber.add(i);
				}
			} else if (categoryName.equalsIgnoreCase("doi")) {
				model.addAttribute("name", "Đồ Đôi");
				if (page==null) {
					model.addAttribute("listproduct", productDetailSv.getListProductDetails(1, "đôi"));
				}
				else {
					model.addAttribute("listproduct", productDetailSv.getListProductDetails(Integer.valueOf(page), "đôi"));
				}
				for (int i = 1; i <= productDetailSv.getNumberOfPage("đôi"); i++) {
					ListNumber.add(i);
				}
			} else if (categoryName.equalsIgnoreCase("new")) {
				model.addAttribute("name", "Sản Phẩm Mới Về");
				if (page==null) {
					model.addAttribute("listproduct", productDetailSv.getListProductDetails(1, "new"));
				}
				else {
					model.addAttribute("listproduct", productDetailSv.getListProductDetails(Integer.valueOf(page), "new"));
				}
				for (int i = 1; i <= productDetailSv.getNumberOfPage("new"); i++) {
					ListNumber.add(i);
				}
			} else {
				modelAndView = new ModelAndView("common/notfound");
			}
			model.addAttribute("listNumber", ListNumber);
			model.addAttribute("path", categoryName);
		return modelAndView;
	}
}
