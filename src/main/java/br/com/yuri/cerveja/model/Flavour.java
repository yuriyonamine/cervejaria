package br.com.yuri.cerveja.model;

public enum Flavour {
	CRISP("Crisp"),
	HOP("Hop"),
	MALT("malt"),
	ROAST("Roast"),
	SMOKE("Smoke"),
	FRUIT_SPICE("Fruit and Spice");
	
	private String description;

	private Flavour(String flavour){
		this.description=flavour;
	}

	public String getDescription() {
		return description;
	}
	
	
	
}
