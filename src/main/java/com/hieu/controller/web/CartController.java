package com.hieu.controller.web;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hieu.bean.Cart;
import com.hieu.bean.ProductDetail;
import com.hieu.service.inter.CartSv;
import com.hieu.service.inter.ProductDetailSv;
import com.hieu.service.inter.ProductSv;

@Controller
public class CartController {

	@Autowired
	private ProductDetailSv productDetailSv;
	
	@Autowired 
	private CartSv cartSv;
	
	@RequestMapping(value = "/addcart", method = RequestMethod.POST)
	public String addToCart(HttpServletResponse resp, HttpServletRequest req) throws UnsupportedEncodingException {
		List<Cart> listCart = new ArrayList<Cart>();
		Cookie[] ck = req.getCookies();
		String stringProduct = null;
		Gson gson = new Gson();
		
		// lay chuoi tu cookie xong xoa chuoi
		for (Cookie c: ck) {
			if (c.getName().equals("PRODUCT") && !c.getValue().equals("")) {
				stringProduct = c.getValue();
				c.setMaxAge(0);
			}
		}
		
		// neu khong null thi chuyen chuoi sang dang collection
		//khong chuyen duoc chuoi null vao decode
		if (stringProduct != null) {
			String listProduct = URLDecoder.decode(stringProduct, "UTF-8");
			Type objectType = new TypeToken<ArrayList<Cart>>(){}.getType();
			listCart = gson.fromJson(listProduct, objectType);
		}
		
		ProductDetail product = productDetailSv.findAProductDetail(Integer.valueOf(req.getParameter("idpro")));
		Cart cart = new Cart(product.getId(), 1, product.getPrice());
		
		// neu san pham co trong list thi sua lai so luong va gia tien 
		int flag = 0;
		for (Cart c : listCart) {
			if (c.getId()==cart.getId()) {
				c.setQuantity(c.getQuantity()+1);
				BigDecimal pr = new BigDecimal(5);
				c.setPrice(c.getPrice().multiply(new BigDecimal(c.getQuantity())));
				flag = 1;
			}
		}
		
		//kiem tra neu flag ==0 tu la khong co san pham trong list thi them vao list
		if (flag ==0) {
			listCart.add(cart);
		}
		
		// chuyen collection sang json va add vao cookie
		String pro = gson.toJson(listCart);
		Cookie cookie = new Cookie("PRODUCT", URLEncoder.encode(pro,"UTF-8"));
		cookie.setMaxAge(60*60*24);
		resp.addCookie(cookie);
		return "redirect:trang-chu";
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView getCart (HttpServletRequest req, ModelMap model) {
		ModelAndView modelAndView = new ModelAndView("web/cart");
		List<Cart> listCart = new ArrayList<Cart>();
		listCart = cartSv.getCart(req);
		BigDecimal totalMoney = new BigDecimal(0);
		for (Cart cart:listCart) {
			totalMoney = totalMoney.add(cart.getPrice());
		}
		model.addAttribute("listCart", listCart);
		model.addAttribute("totalMoney", totalMoney);
		return modelAndView;
	}
	
	@RequestMapping(value = "/deleteitem", method = RequestMethod.GET)
	public String deleteItemCart(HttpServletRequest req, HttpServletResponse resp, @RequestParam("id") String id) {
		cartSv.deleteItemCart(req, resp, Integer.valueOf(id));
		return "redirect: cart";
	}
}
