package com.formation.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")

public class AdminController {

	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public ModelAndView directWithMessage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/list");
		// modelAndView.addObject("messages", serv.findAllMessages());
		return modelAndView;
	}

}
