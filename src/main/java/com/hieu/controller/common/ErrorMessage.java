package com.hieu.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorMessage {
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView error() {
		ModelAndView modelAndView = new ModelAndView("common/error");
			
		return modelAndView;
	}
}
