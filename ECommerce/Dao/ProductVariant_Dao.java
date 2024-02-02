package com.sathish.ECommerce.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sathish.ECommerce.Dto.ProductVariant_Dto;
import com.sathish.ECommerce.Repository.ProductVariantRepository;

@Repository
public class ProductVariant_Dao {
	 
	@Autowired
	private ProductVariantRepository productVariantRepository;

	public void addProductVariant(ProductVariant_Dto productVariant_Dto) {
		productVariantRepository.save(productVariant_Dto);
	}

	public ProductVariant_Dto getProductVariantById(long productVariant_id) {
		return productVariantRepository.findById(productVariant_id).orElse(null);
	}

	public void deleteProductVariantById(long productVariant_id) {
		productVariantRepository.deleteById(productVariant_id);
	}

	public void updateProductVarient(ProductVariant_Dto productVarient_Dto) {
		productVariantRepository.save(productVarient_Dto);
	}

	public List<ProductVariant_Dto> getAllProductVariants() {
		return productVariantRepository.findAll();
	}
}
