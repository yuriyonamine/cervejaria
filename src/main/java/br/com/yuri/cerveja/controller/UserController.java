package br.com.yuri.cerveja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

	@RequestMapping("/new")
	public String novo() {
		return "user/RegisterUser";
	}
	
}