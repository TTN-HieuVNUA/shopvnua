package com.hieu.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hieu.service.inter.ProductDetailSv;
import com.hieu.service.inter.ProductSv;

@Controller
public class DetailProductController {

	@Autowired
	private ProductDetailSv productDetailSv;
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView productDetail(ModelMap modelmap, @RequestParam("id") String id) {
		ModelAndView modelAndView = new ModelAndView("web/detail");
			modelmap.addAttribute("product", productDetailSv.findAProductDetail(Integer.valueOf(id)));
			int idOfProduct = productDetailSv.findAProductDetail(Integer.valueOf(id)).getProductid().getId();
			modelmap.addAttribute("listProductDetail", productDetailSv.getListProductDetail(idOfProduct));
		return modelAndView;
	}
}
