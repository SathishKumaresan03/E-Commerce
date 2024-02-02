package com.sathish.ECommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sathish.ECommerce.Dto.ProductVariant_Dto;
import com.sathish.ECommerce.Dto.Product_Dto;
import com.sathish.ECommerce.Responce.ResponceStructure;
import com.sathish.ECommerce.Service.Product_Service;

@RestController
@RequestMapping("/product")
public class Product_Controller {

	@Autowired
	private Product_Service product_Service;

	// Method used to add products
	@PostMapping("/add")
	public ResponceStructure<Product_Dto> addProduct(@RequestBody Product_Dto product_Dto) {
		return product_Service.addProduct(product_Dto);
	}

	// method used to get product by poduct ID
	@GetMapping("/get/{product_id}")
	public Object getProductById(@PathVariable long product_id) {
		return product_Service.getProductById(product_id);
	}

	// method used to delete product by poduct ID
	@DeleteMapping("/delete/{product_id}")
	public Object deleteProductById(@PathVariable long product_id) {
		return product_Service.deleteProductById(product_id);
	}

	// method used to update product by poduct ID
	@PutMapping("/update/{product_id}")
	public ResponceStructure<Product_Dto> updateProduct(@RequestBody Product_Dto product_Dto,
			@PathVariable long product_id) {
		return product_Service.updateProduct(product_id, product_Dto);
	}

	// This method is used to get all product data's
	@GetMapping("/GetAllProducts")
	public ResponceStructure<List<Product_Dto>> fetchAllProduct() {
		return product_Service.fetchAllProduct();
	}

	// its a searching method by name,description,variant Name
	@GetMapping("/search")
	public ResponceStructure<List<Product_Dto>> searchProducts(@RequestParam(required = false) String query) {
		return product_Service.searchProducts(query);
	}

	// adding variant to particular product
	@PostMapping("/{productId}/variants")
	public ResponceStructure<List<Product_Dto>> addVariantToProduct(@PathVariable long productId,
			@RequestBody ProductVariant_Dto variant) {
		return product_Service.addVariantToProduct(productId, variant);
	}
}
