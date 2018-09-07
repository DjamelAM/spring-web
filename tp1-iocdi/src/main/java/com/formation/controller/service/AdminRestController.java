package com.formation.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.model.MessageDto;
import com.formation.service.MessageService;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

	@Autowired
	MessageService serv;

	@GetMapping("/messages")
	public List<MessageDto> directWithMessage() {

		return serv.findAllMessages();
	}
	//
	// @GetMapping("/ajout")
	// public String submit(@ModelAttribute("message") MessageDto messageDto,
	// BindingResult result, ModelMap model) {
	// if (result.hasErrors()) {
	// return "error";
	// }
	//
	// return "admin/create_message";
	// }
	//
	// @PostMapping("/ajout")
	// public String saveMessage(@RequestBody MessageDto messageDto,
	// BindingResult results) {
	// if (results.hasErrors()) {
	// return "admin/create_message";
	// }
	// serv.send(messageDto);
	// return "admin/create_message";
	// }
}
