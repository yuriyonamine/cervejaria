package br.com.yuri.cerveja.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Beer {
	@NotBlank(message="SKU is required")
	private String sku;

	@NotBlank(message="Name is required")
	private String name;

	@NotBlank(message="Description is required")
	@Size(min = 1, max = 50, message="The size of description must be between 1 and 50")
	private String description;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
