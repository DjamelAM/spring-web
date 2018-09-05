package com.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.formation.service.MessageService;

@Controller
@RequestMapping("/admin")

public class AdminController {
	@Autowired
	MessageService serv;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView directWithMessage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/list");
		modelAndView.addObject("messages", serv.findAllMessages());
		return modelAndView;
	}

	@Controller
	@RequestMapping("/ajout")
	public class HelloWorldController {
		@GetMapping("")
		@ResponseBody
		public String simple() {
			return "Pas maintenant !";
		}
	}
}
