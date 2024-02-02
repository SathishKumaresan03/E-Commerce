package com.sathish.ECommerce.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Product-Variant")
@Getter
@Setter
public class ProductVariant_Dto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String sku;
	private double additionalCost;
	private int stockCount;
	
	@ManyToOne
    @JoinColumn(name = "product_id")
    private Product_Dto product;
}
