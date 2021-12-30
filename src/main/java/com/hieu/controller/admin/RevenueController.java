package com.hieu.controller.admin;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hieu.service.inter.AccountSv;
import com.hieu.service.inter.InvoiceDetailSv;
import com.hieu.service.inter.InvoiceSv;

@Controller
public class RevenueController {
	@Autowired
	private AccountSv accountSv;

	@Autowired
	private InvoiceSv invoiceSv;
	
	@Autowired
	private InvoiceDetailSv invoiceDetailSv;
	
	@RequestMapping(value = "/admin/revenue", method = RequestMethod.GET)
	public ModelAndView revenue(HttpServletResponse respon, HttpServletRequest request,
			@RequestParam(name="month", required = false) Integer month,
			@RequestParam(name="year", required = false) Integer year) {
		HttpSession session = request.getSession();
		if (session.getAttribute("USER_NAME") != null
				&& accountSv.CheckRoleAdmin((String) session.getAttribute("USER_NAME"))) {
			ModelAndView modelAndView = new ModelAndView("admin/revenue");
			int day = 0;
				if(month == null && year == null) {
					LocalDateTime date = LocalDateTime.now();
					year = date.getYear();
					month = date.getMonthValue();
				}
				request.setAttribute("month", month);
				request.setAttribute("year", year);
				request.setAttribute("sum", invoiceSv.getSumTotalMoney(month, year));
				request.setAttribute("cusName", invoiceSv.getCusName(month, year));
				request.setAttribute("empName", invoiceSv.getEmpName(month, year));
				request.setAttribute("bestSalePro", invoiceDetailSv.getBestSallingProduct(month, year));
			return modelAndView;
		} else {
			try {
				respon.sendRedirect("/shopvnua/login");
			} catch (IOException e) {

			}
			return null;
		}
	}
}
