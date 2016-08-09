package br.com.yuri.cerveja.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.yuri.cerveja.model.Client;
@Controller
public class ClientController {
	
	@RequestMapping("/clients/new")
	public String newClient(Client client, Model model){
		model.addAttribute("client", client);
		return "client/RegisterClient";
	}
}
