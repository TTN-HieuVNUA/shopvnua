package com.hieu.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignOut {

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String signOut(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if(!session.getAttribute("USER_NAME").equals("")) {
			session.removeAttribute("USER_NAME");
			session.invalidate();
		}
		return "redirect: login";
	}
}
