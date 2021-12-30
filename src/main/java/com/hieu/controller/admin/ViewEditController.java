package com.hieu.controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hieu.bean.Product;
import com.hieu.bean.ProductDetail;
import com.hieu.service.inter.AccountSv;
import com.hieu.service.inter.CategorySv;
import com.hieu.service.inter.ProductDetailSv;
import com.hieu.service.inter.ProductSv;
import com.hieu.service.inter.TradeMarkSv;

@Controller
public class ViewEditController {

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
	
	@RequestMapping(value = "/admin/editproduct", method = RequestMethod.GET)
	public ModelAndView showViewEdit(Model model, @RequestParam(value = "id") int id,
			@RequestParam(value = "idp") int idp,HttpServletResponse respon, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("USER_NAME") !=null && accountSv.checkUserRole((String)session.getAttribute("USER_NAME")) != true) {
		ModelAndView modelAndView = new ModelAndView("admin/editProduct");
		Product product = productSv.findAProduct(id);
		ProductDetail productDetail = productDetailSv.findAprProductDetail(idp);
		model.addAttribute("category", categorySv.getlistCategories());
		model.addAttribute("trademark", tradeMarkSv.getListTradeMarks());
		model.addAttribute("product", product);
		model.addAttribute("productdetail", productDetail);
		model.addAttribute("linkimage", productDetail.getImage());
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

	@RequestMapping(value = "/admin/editaction", method = RequestMethod.POST)
	public String addAction(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Product product,
			@ModelAttribute ProductDetail prodetail, BindingResult result, ModelMap m, Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("USER_NAME") !=null && accountSv.checkUserRole((String)session.getAttribute("USER_NAME")) != true ) {
		try {
			String image = productDetailSv.editImage(prodetail);
			prodetail.setImage(image);
		} catch (Exception e) {
			prodetail.setImage(request.getParameter("img"));
		}

		int iddetail = Integer.parseInt(request.getParameter("iddetail"));
		prodetail.setId(iddetail);
		try {
			productDetailSv.edit(prodetail, (String)session.getAttribute("USER_NAME"));
		} catch (Exception e) {
			return "redirect: /shopvnua/error";
		}
		return "redirect:listproduct";
		}
		else {
			return "redirect:/shopvnua/login";
		}
	}

}
