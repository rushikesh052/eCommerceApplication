package com.rushi.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String sku;
	
	private String name; 
	
	private String description;
	
	private Double unitPrice;
	
	private String imageUrl;
	
	private Boolean active;
	
	private Integer unitsInStock;
	
	private Date dateCreated;
	
	private Date dateUpdated;
	
	
	@ManyToOne
	@JoinColumn(name="category_id",nullable=false)
	private ProductCategory category;
	
	
}
