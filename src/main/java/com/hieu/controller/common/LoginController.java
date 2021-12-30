package com.hieu.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.hieu.bean.Account;
import com.hieu.service.inter.AccountSv;

@Controller
public class LoginController {

	@Autowired
	private AccountSv accountSv;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView viewLogin(ModelMap model, @RequestParam(value = "message", required = false) String message) {
		ModelAndView modelAndView = new ModelAndView("common/login");
		if(message != null) {
			model.put("mess", "error");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/checklogin", method = RequestMethod.POST)
	public String checkLogin(HttpServletRequest request, ModelMap model) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			if (accountSv.checkAccount(username, password) == true) {
				Account account = accountSv.findAccount(username);
				HttpSession session = request.getSession();
				session.setAttribute("USER_NAME", account.getUsername());
				session.setAttribute("ID_Account", account.getId());

				if (accountSv.checkUserRole(username)) {
					return "redirect:trang-chu";
				} else {
					return "redirect:admin/trang-chu";
				}
			}
		} catch (Exception e) {
			model.put("message", "error");
			return "redirect:login";
		}
		return null;
	}
}
