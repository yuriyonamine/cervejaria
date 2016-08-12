package br.com.yuri.cerveja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cities")
public class CityController {
	@RequestMapping("new")
	public String newCity(){
		return "city/RegisterCity";
	}
}
