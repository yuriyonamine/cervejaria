package br.com.yuri.cerveja.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import br.com.yuri.cerveja.validation.SKU;

@Entity
@Table(name = "beer")
public class Beer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@SKU
	@NotBlank(message = "SKU is required")
	private String sku;

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Description is required")
	@Size(max = 50, message = "The size of description must be between 1 and 50")
	private String description;

	@NotNull(message = "Price is required")
	@DecimalMin(value = "0.01")
	@DecimalMax(value = "9999999.99", message = "The price must be less than R$9.999.999,99")
	private BigDecimal price;

	@NotNull(message = "Alcohol Strength is required")
	@DecimalMax(value = "100.0", message = "The alcohol strength must be less than 100")
	@Column(name = "alcohol_strength")
	private BigDecimal alcoholStrength;

	@NotNull(message = "Comission is required")
	@DecimalMax(value = "100.0", message = "The comission must be less than 100")
	private BigDecimal comission;

	@NotNull(message="Stock quantity is required")
	@Max(value = 9999, message = "The price must be less than 9.999")
	@Column(name = "stock_quantity")
	private Integer stockQuantity;

	@NotNull(message = "Origin is required")
	@Enumerated(EnumType.STRING)
	private Origin origin;

	@NotNull(message = "Flavour is required")
	@Enumerated(EnumType.STRING)
	private Flavour flavour;

	@NotNull(message = "Style is required")
	@ManyToOne
	@JoinColumn(name = "style_id")
	private Style style;

	@PrePersist
	@PreUpdate
	private void prePersistUpdate(){
		this.sku = this.sku.toUpperCase();
	}
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAlcoholStrength() {
		return alcoholStrength;
	}

	public void setAlcoholStrength(BigDecimal alcoholStrength) {
		this.alcoholStrength = alcoholStrength;
	}

	public BigDecimal getComission() {
		return comission;
	}

	public void setComission(BigDecimal comission) {
		this.comission = comission;
	}

	public Integer getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public Flavour getFlavour() {
		return flavour;
	}

	public void setFlavour(Flavour flavour) {
		this.flavour = flavour;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beer other = (Beer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
