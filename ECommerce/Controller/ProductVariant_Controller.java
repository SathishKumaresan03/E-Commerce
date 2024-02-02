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
import org.springframework.web.bind.annotation.RestController;

import com.sathish.ECommerce.Dto.ProductVariant_Dto;
import com.sathish.ECommerce.Responce.ResponceStructure;
import com.sathish.ECommerce.Service.ProductVariant_Service;

@RestController
@RequestMapping("/product-variant")
public class ProductVariant_Controller {

	@Autowired
	private ProductVariant_Service productVariant_Service;

	// This method is used to add productvariant with their product
	@PostMapping("/add")
	public ResponceStructure<ProductVariant_Dto> addProductVarient(@RequestBody ProductVariant_Dto productVarient_Dto) {
		return productVariant_Service.addProductVarient(productVarient_Dto);
	}

	// This method used to get productVariant by variant id
	@GetMapping("/{productvariantID}/get")
	public ResponceStructure<ProductVariant_Dto> getProductVariantById(@PathVariable long productvariantID) {
		return productVariant_Service.getProductVariantById(productvariantID);
	}

	// fetching all product varients
	@GetMapping("/getAll")
	public ResponceStructure<List<ProductVariant_Dto>> getAllProductVariants() {
		return productVariant_Service.getAllProductVariants();
	}

	// Used to update product Variant
	@PutMapping("/{productvariantID}/update")
	public ResponceStructure<ProductVariant_Dto> updateProductVarient(
			@RequestBody ProductVariant_Dto productVarient_Dto, @PathVariable long productvariantID) {

		return productVariant_Service.updateProductVarient(productvariantID, productVarient_Dto);
	}

	// Method used to delete particular varient
	@DeleteMapping("/{productvariantID}/delete")
	public ResponceStructure<ProductVariant_Dto> deleteProductVariantById(@PathVariable long productvariantID) {
		return productVariant_Service.deleteProductVariantById(productvariantID);
	}
}
