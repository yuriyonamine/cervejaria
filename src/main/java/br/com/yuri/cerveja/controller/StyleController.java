package br.com.yuri.cerveja.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.yuri.cerveja.model.Style;
import br.com.yuri.cerveja.service.RegisterStyleService;

@Controller
@RequestMapping("/styles")
public class StyleController {

	@Autowired
	private RegisterStyleService registerStyleService;
	
	@RequestMapping("/new")
	public ModelAndView newStyle(Style style) {
		ModelAndView mav = new ModelAndView("style/RegisterStyle");
		return mav;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView registerStyle(@Valid Style style, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return newStyle(style);
		}
		
		registerStyleService.saveStyle(style);

		redirectAttributes.addFlashAttribute("message", "Registered");
		return new ModelAndView("redirect:/styles/new");
	}
}
