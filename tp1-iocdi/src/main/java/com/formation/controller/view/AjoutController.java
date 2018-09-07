package com.formation.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formation.model.MessageDto;
import com.formation.validator.MessageValidator;

@Controller
public class AjoutController {

	// @RequestMapping(value = "/admin/new", method = RequestMethod.GET)
	// public ModelAndView newMessage() {
	// ModelAndView modelAndView = new ModelAndView();
	// modelAndView.setViewName("admin/create_message");
	// // modelAndView.addObject("messages", serv.findAllMessages());
	// return modelAndView;
	// }

	@RequestMapping(value = "/admin/new", method = RequestMethod.GET)
	public String submit(@ModelAttribute("message") MessageDto messageDto, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}

		return "admin/create_message";
	}

	@RequestMapping(value = "/admin/new", method = RequestMethod.POST)
	public String sub(@Validated @ModelAttribute("message") MessageDto messageDto, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			return "admin/create_message";
		}
		// serv.send(messageDto);
		return "admin/create_message";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new MessageValidator());

	}

}
