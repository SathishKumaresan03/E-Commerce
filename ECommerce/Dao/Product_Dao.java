package com.sathish.ECommerce.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sathish.ECommerce.Dto.Product_Dto;
import com.sathish.ECommerce.Repository.ProductRepository;

@Repository
public class Product_Dao {

	@Autowired
	private ProductRepository productRepository;

	public void addProduct(Product_Dto product_Dto) {
		productRepository.save(product_Dto);
	}

	public Product_Dto getProductById(long product_id) {
		return productRepository.findById(product_id).orElse(null);
	}

	public void deleteProductById(long product_id) {
		productRepository.deleteById(product_id);
	}

	public void updateProduct(Product_Dto product_Dto) {
		productRepository.save(product_Dto);
	}

	public List<Product_Dto> fetchAllProduct() {
		return productRepository.findAll();
	}
	
	public Product_Dto addVariantToProduct(Product_Dto product) {
        return productRepository.save(product);
    }
	
	public List<Product_Dto> searchProducts(String query) {
        return productRepository.findByNameContainingOrDescriptionContaining(query, query);
    }
}
