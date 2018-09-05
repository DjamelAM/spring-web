package com.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/healthcheck")
public class HelloWorldController {
	@GetMapping("/simple")
	@ResponseBody
	public String simple() {
		return "Hello !";
	}
}