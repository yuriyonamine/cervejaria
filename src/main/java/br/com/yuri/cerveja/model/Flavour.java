package br.com.yuri.cerveja.model;

public enum Flavour {
	CRISP("Crisp"),
	HOP("Hop"),
	MALT("malt"),
	ROAST("Roast"),
	SMOKE("Smoke"),
	FRUIT_SPICE("Fruit and Spice");
	
	private String flavour;

	private Flavour(String flavour){
		this.flavour=flavour;
	}
	
}
