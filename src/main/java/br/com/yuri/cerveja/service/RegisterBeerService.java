package br.com.yuri.cerveja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.yuri.cerveja.model.Beer;
import br.com.yuri.cerveja.repository.Beers;

@Service
public class RegisterBeerService {
	@Autowired
	private Beers beers;
	
	@Transactional
	public void save(Beer beer){
		beers.save(beer);
	}
}
