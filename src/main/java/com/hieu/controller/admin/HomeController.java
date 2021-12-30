package com.hieu.controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hieu.bean.Account;
import com.hieu.repository.inter.CategoryRepos;
import com.hieu.service.inter.AccountSv;
import com.hieu.service.inter.EmployeeSv;


@Controller(value = "homeOfAdmin")

public class HomeController {
	
	@Autowired
	private AccountSv accountSv;

	@Autowired
	private EmployeeSv employeeSv;
	
	@RequestMapping(value = "/admin/trang-chu", method = RequestMethod.GET)
	public ModelAndView homeOfAdmin(Model model, HttpServletResponse respon, HttpServletRequest request, ModelMap modelmap) {
		HttpSession session = request.getSession();
		if(session.getAttribute("USER_NAME") !=null && accountSv.checkUserRole((String)session.getAttribute("USER_NAME")) != true) {
		ModelAndView modelAndView = new ModelAndView("admin/home");
			modelmap.put("listemployee", employeeSv.getListEmployee());
			modelmap.put("Role", accountSv.CheckRoleAdmin((String)session.getAttribute("USER_NAME")));
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
	
	@RequestMapping(value = "/admin/editprofile", method = RequestMethod.GET)
	public ModelAndView editProfile(HttpServletResponse respon, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("USER_NAME") !=null && accountSv.checkUserRole((String)session.getAttribute("USER_NAME")) != true) {
		ModelAndView modelAndView = new ModelAndView("admin/editProfile");
			
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
}
