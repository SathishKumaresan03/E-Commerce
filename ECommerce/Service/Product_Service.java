package com.sathish.ECommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sathish.ECommerce.Dao.Product_Dao;
import com.sathish.ECommerce.Dto.ProductVariant_Dto;
import com.sathish.ECommerce.Dto.Product_Dto;
import com.sathish.ECommerce.ExceptionHandling.UserdefinedException;
import com.sathish.ECommerce.Responce.ResponceStructure;

@Service
public class Product_Service {

	@Autowired
	private Product_Dao product_Dao;

	public ResponceStructure<Product_Dto> addProduct(Product_Dto product_Dto) {
		product_Dao.addProduct(product_Dto);
		ResponceStructure<Product_Dto> responceStructure = new ResponceStructure<>();
		responceStructure.setData(product_Dto);
		responceStructure.setMessage("Data succesfully added");
		responceStructure.setStatus(HttpStatus.CREATED.value());
		return responceStructure;
	}

	public Object getProductById(long product_id) {
		Product_Dto  product_Dto= product_Dao.getProductById(product_id);
		if (product_Dto!=null) { //Checking data present or not
			ResponceStructure<Product_Dto> responceStructure = new ResponceStructure<>();
			responceStructure.setData(product_Dto);
			responceStructure.setMessage("Data succesfully fetched");
			responceStructure.setStatus(HttpStatus.FOUND.value());
			return responceStructure;
		} else {
			throw new UserdefinedException("Data not found");
		}
	}

	public Object deleteProductById(long product_id) {
		product_Dao.deleteProductById(product_id);
		Product_Dto product_Dto= product_Dao.getProductById(product_id);
		if (product_Dto==null) {//checking data is deleted
			ResponceStructure<Product_Dto> responceStructure = new ResponceStructure<>();
			responceStructure.setData(null);
			responceStructure.setMessage("Data is not present OR product id is wrong");
			responceStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return responceStructure;
		} else {
			ResponceStructure<Product_Dto> responceStructure = new ResponceStructure<>();
			responceStructure.setData(null);
			responceStructure.setMessage("Data succesfully Deleted");
			responceStructure.setStatus(HttpStatus.OK.value());
			return responceStructure;
		}
	}

	public ResponceStructure<Product_Dto> updateProduct(Long Product_id,Product_Dto product_Dto) {
		Product_Dto  existing_Product_Dto=product_Dao.getProductById(Product_id);
		if(product_Dto!=null) {//checking data present
			existing_Product_Dto.setId(Product_id);
			existing_Product_Dto.setDescription(product_Dto.getDescription());
			existing_Product_Dto.setName(product_Dto.getName());
			existing_Product_Dto.setPrice(product_Dto.getPrice());
			existing_Product_Dto.setVariants(product_Dto.getVariants());
			product_Dao.updateProduct(existing_Product_Dto);
			
			ResponceStructure<Product_Dto> responceStructure = new ResponceStructure<>();
			responceStructure.setData(existing_Product_Dto);
			responceStructure.setMessage("Data Succesfully updated");
			responceStructure.setStatus(HttpStatus.OK.value());
			return responceStructure;
		}else {
			throw new UserdefinedException("Data not found");
			}
	}

	public ResponceStructure<List<Product_Dto>> fetchAllProduct() {
		List<Product_Dto> list = product_Dao.fetchAllProduct();
		if (list.isEmpty()) {
			ResponceStructure<List<Product_Dto>> responceStructure = new ResponceStructure<>();
			responceStructure.setData(null);
			responceStructure.setMessage("No data present");
			responceStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return responceStructure;
		} else {
			ResponceStructure<List<Product_Dto>> responceStructure = new ResponceStructure<>();
			responceStructure.setData(list);
			responceStructure.setMessage("All data fetched");
			responceStructure.setStatus(HttpStatus.FOUND.value());
			return responceStructure;
		}
		
	}

	public ResponceStructure<List<Product_Dto>> addVariantToProduct(Long productId, ProductVariant_Dto variant) {
  
        Product_Dto  product_Dto= product_Dao.getProductById(productId);
        if (product_Dto!=null) {//checking data present
            variant.setProduct(product_Dto);
            product_Dto.getVariants().add(variant);
            product_Dao.addVariantToProduct(product_Dto);
            
    		ResponceStructure<List<Product_Dto>> responceStructure = new ResponceStructure<>();
            responceStructure.setData(null);
            responceStructure.setMessage("Succesfully added");
            responceStructure.setStatus(HttpStatus.OK.value());
            return responceStructure;
        }else {
    		throw new UserdefinedException("Data not found");
        }
    }

	public ResponceStructure<List<Product_Dto>> searchProducts(String query) {
		if (query == null) {//checking null or not
			ResponceStructure<List<Product_Dto>> responceStructure = new ResponceStructure<>();
			responceStructure.setData(null);
			responceStructure.setMessage("Data not find");
			responceStructure.setStatus(HttpStatus.BAD_REQUEST.value());
			return responceStructure;
		}

		List<Product_Dto> matchingProducts = product_Dao.searchProducts(query);

		ResponceStructure<List<Product_Dto>> responceStructure = new ResponceStructure<>();
		responceStructure.setData(matchingProducts);
		responceStructure.setMessage("All data fetched");
		responceStructure.setStatus(HttpStatus.FOUND.value());
		return responceStructure;
	}
}
