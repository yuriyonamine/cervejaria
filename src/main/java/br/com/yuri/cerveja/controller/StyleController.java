package br.com.yuri.cerveja.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.yuri.cerveja.model.Style;
import br.com.yuri.cerveja.service.RegisterStyleService;
import br.com.yuri.cerveja.service.exception.RegisterStyleNameException;

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
		try {
			registerStyleService.saveStyle(style);
		} catch (RegisterStyleNameException ex) {
			result.rejectValue("name", ex.getMessage(), ex.getMessage());
			return newStyle(style);
		}

		redirectAttributes.addFlashAttribute("message", "Registered");
		return new ModelAndView("redirect:/styles/new");
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody @Valid Style style, BindingResult result) {
		if(result.hasErrors()){
			return ResponseEntity.badRequest().body(result.getFieldError("name").getDefaultMessage());
		}
		
		try{
			registerStyleService.saveStyle(style);
		}catch(RegisterStyleNameException ex){
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		
		return ResponseEntity.ok(style);
	}
}
