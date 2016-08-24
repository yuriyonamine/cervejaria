package br.com.yuri.cerveja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.yuri.cerveja.model.Style;
import br.com.yuri.cerveja.repository.Styles;

@Service
public class RegisterStyleService {
	
	@Autowired
	private Styles styles;
	
	@Transactional
	public void saveStyle(Style style){
		styles.save(style);
	}
}
