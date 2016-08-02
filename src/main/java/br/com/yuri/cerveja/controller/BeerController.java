package br.com.yuri.cerveja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.yuri.cerveja.model.Beer;

@Controller
public class BeerController {

	@RequestMapping("/beers/new")
	public String newBeer() {
		return "beer/RegisterBeer";
	}

	@RequestMapping(value = "/beers/new", method = RequestMethod.POST)
	public String registerBeer(Beer beer) {
		System.out.println(beer.getSku());
		return "beer/RegisterBeer";

	}
}
