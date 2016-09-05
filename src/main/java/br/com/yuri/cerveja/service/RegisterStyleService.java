package br.com.yuri.cerveja.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.yuri.cerveja.model.Style;
import br.com.yuri.cerveja.repository.Styles;
import br.com.yuri.cerveja.service.exception.RegisterStyleNameException;

@Service
public class RegisterStyleService {
	
	@Autowired
	private Styles styles;
	
	@Transactional
	public void saveStyle(Style style){
		Optional<Style> styleOptional = styles.findByNameIgnoreCase(style.getName());
		
		if(styleOptional.isPresent()){
			throw new RegisterStyleNameException("Style name is already registered");
		}
		
		styles.saveAndFlush(style);
	}
}
