package com.sathish.ECommerce.Dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Product")
@Getter
@Setter
public class Product_Dto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private double price;

    @OneToMany(mappedBy = "product")
	private List<ProductVariant_Dto> variants = new ArrayList<>();

}
