package br.com.yuri.cerveja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/users/new")
	public String novo() {
		return "user/RegisterUser";
	}
	
}