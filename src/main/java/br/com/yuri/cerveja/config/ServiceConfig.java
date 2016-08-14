package br.com.yuri.cerveja.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.yuri.cerveja.service.RegisterBeerService;

@Configuration
@ComponentScan(basePackageClasses={RegisterBeerService.class})
public class ServiceConfig {

}
