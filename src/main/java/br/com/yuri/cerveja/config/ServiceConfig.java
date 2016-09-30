package br.com.yuri.cerveja.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.yuri.cerveja.service.RegisterBeerService;
import br.com.yuri.cerveja.storage.local.LocalPhotoStorage;
import br.com.yuri.cerveja.storage.local.PhotoStorage;

@Configuration
@ComponentScan(basePackageClasses={RegisterBeerService.class})
public class ServiceConfig {
	
	@Bean
	public PhotoStorage localPhotoStorage(){
		return new LocalPhotoStorage();	
	}
}
