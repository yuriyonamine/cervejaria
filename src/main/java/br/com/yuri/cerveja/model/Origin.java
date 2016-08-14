package br.com.yuri.cerveja.model;

public enum Origin {
	NATIONAL("National"), 
	INTERNATIONAL("International");

	private String description;

	private Origin(String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
