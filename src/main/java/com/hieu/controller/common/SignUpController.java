package com.hieu.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hieu.service.inter.AccountSv;

@Controller
public class SignUpController {

	@Autowired
	private AccountSv accountSv;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String viewSignUp() {
		return "common/signup";
	}
	
	@RequestMapping(value = "/signupaction", method = RequestMethod.POST)
	public String signup(HttpServletRequest request) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		
		try {
			if(password.equals(repassword) && !password.equals("") && !repassword.equals("") && name !="" && email !="") {
				if(accountSv.regiser(name, email, repassword)) {
					return "redirect:login";
				}
				else {
					return "redirect:error";
				}
			}
			else {
				return "redirect:signup";
			}
		} catch (Exception e) {
			return "redirect:error";
		}
	}
}
