package br.com.yuri.cerveja.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/styles")
public class StyleController {

	@RequestMapping("/new")
	public String newStyle(){
		return "style/RegisterStyle";
	}
}
