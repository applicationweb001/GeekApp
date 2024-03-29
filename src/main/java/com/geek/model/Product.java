package com.geek.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


import com.geek.dateAudit.DateAudit;

@Entity
@Table(name = "products")
public class Product extends DateAudit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Por favor ingrese el nombre del producto")
	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	@Column(name = "unit_price")
	private double unitPrice;

	public Product() {
		this.setCreatedAt(new Date());
		this.setUpdatedAt(new Date());
	}

	public Product(@NotEmpty String name, @NotEmpty double unitPrice,Category category) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.category=category;
		this.setCreatedAt(new Date());
		this.setUpdatedAt(new Date());

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
}
