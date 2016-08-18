package br.com.yuri.cerveja.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.yuri.cerveja.model.Beer;
import br.com.yuri.cerveja.model.Flavour;
import br.com.yuri.cerveja.model.Origin;
import br.com.yuri.cerveja.repository.Styles;
import br.com.yuri.cerveja.service.RegisterBeerService;

@Controller
@RequestMapping("/beers")
public class BeerController {
	@Autowired
	private Styles styles; 
	
	@Autowired
	private RegisterBeerService registerBeerService;
	
	private static final Logger logger = LoggerFactory.getLogger(BeerController.class);
	@RequestMapping("/new")
	public ModelAndView newBeer(Beer beer) {
		ModelAndView mav = new ModelAndView("beer/RegisterBeer");
		mav.addObject("flavours", Flavour.values());
		mav.addObject("styles", styles.findAll());
		mav.addObject("origins", Origin.values());
		return mav;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView registerBeer(@Valid Beer beer, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()){
			return newBeer(beer);
		}
		
		registerBeerService.save(beer);

		redirectAttributes.addFlashAttribute("message", "Registered");
		return new ModelAndView("redirect:/beers/new");

	}	
}
