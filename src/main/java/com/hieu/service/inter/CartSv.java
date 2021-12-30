package com.hieu.service.inter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hieu.bean.Cart;

public interface CartSv {

	List<Cart> getCart(HttpServletRequest req);
	
	void deleteItemCart(HttpServletRequest req,HttpServletResponse resp,int id);
}
