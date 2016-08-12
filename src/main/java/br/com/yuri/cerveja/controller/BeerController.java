package br.com.yuri.cerveja.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.yuri.cerveja.model.Beer;

@Controller
@RequestMapping("/beers")
public class BeerController {

	private static final Logger logger = LoggerFactory.getLogger(BeerController.class);
	@RequestMapping("/new")
	public String newBeer(Beer beer, Model model) {
		logger.error("Erro!!!!!!");
		logger.info("Informacao!!!!");
		model.addAttribute("beer", new Beer());
		return "beer/RegisterBeer";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String registerBeer(@Valid Beer beer, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()){
			model.addAttribute("beer", beer);
			return "beer/RegisterBeer";
		}

		redirectAttributes.addFlashAttribute("message", "Registered");
		return "redirect:/beers/new";

	}	
}
