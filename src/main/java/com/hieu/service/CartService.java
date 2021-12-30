package com.hieu.service;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hieu.bean.Cart;
import com.hieu.service.inter.CartSv;
import com.hieu.service.inter.ProductDetailSv;

@Service
public class CartService implements CartSv{

	@Autowired
	private ProductDetailSv productDetailSv;
	
	@Override
	public List<Cart> getCart(HttpServletRequest req) {
		List<Cart> cartList = new ArrayList<Cart>();
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie: cookies) {
			if (cookie.getName().equals("PRODUCT")) {
				String list = cookie.getValue();
				if (!list.equals("")) {
					String encode;
					try {
						encode = URLDecoder.decode(list,"UTF-8");
						Gson gson = new Gson();
						Type objectType =new TypeToken<ArrayList<Cart>>(){}.getType();
						cartList = gson.fromJson(encode, objectType);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		for (Cart cart: cartList) {
			cart.setName(productDetailSv.findAProductDetail(cart.getId()).getProductid().getName());
			cart.setImage(productDetailSv.findAProductDetail(cart.getId()).getImage());
		}
		return cartList;
	}

	@Override
	public void deleteItemCart(HttpServletRequest req,HttpServletResponse resp,int id) {
		List<Cart> listCart = new ArrayList<Cart>();
		String stringCookie=null;
		String stringCookieJson =null;
		Gson gson = new Gson();
		Cookie[] ck = req.getCookies();
		
		for (Cookie cookie: ck) {
			if (cookie.getName().equals("PRODUCT")) {
				stringCookie = cookie.getValue();
			}
		}
		
		// neu chuoi khong null thi decode roi chuyen sang dang collection
		if (stringCookie !=null) {
			try {
				stringCookieJson = URLDecoder.decode(stringCookie,"UTF-8");
				Type objectType = new TypeToken<ArrayList<Cart>>(){}.getType();
				listCart = gson.fromJson(stringCookieJson, objectType);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		// duyet danh sach xoa di san pham co id truyen vao
		for (int i = 0; i < listCart.size(); i++) {
			if (listCart.get(i).getId()==id) {
				listCart.remove(i);
			}
		}
		
		// neu danh sach item trong cart van con thi se chuyen sang json va encode va add vao cookie
		if (listCart.isEmpty() == false) {
			String jsonString = gson.toJson(listCart);
			try {
				String encodeString = URLEncoder.encode(jsonString,"UTF-8");
				Cookie cookie = new Cookie("PRODUCT", encodeString);
				cookie.setMaxAge(60*60*24);
				resp.addCookie(cookie);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		// khi danh sach khong con san pham nao thi se xoa luon cookie
		else {
			Cookie cookie = new Cookie("PRODUCT", "");
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}
	}

}
