package com.sathish.ECommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sathish.ECommerce.Dao.ProductVariant_Dao;
import com.sathish.ECommerce.Dto.ProductVariant_Dto;
import com.sathish.ECommerce.ExceptionHandling.UserdefinedException;
import com.sathish.ECommerce.Responce.ResponceStructure;

@Service
public class ProductVariant_Service {

	@Autowired
	private ProductVariant_Dao productVarient_Dao;

	public ResponceStructure<ProductVariant_Dto> addProductVarient(ProductVariant_Dto productVarient_Dto) {
		productVarient_Dao.addProductVariant(productVarient_Dto);

		ResponceStructure<ProductVariant_Dto> responceStructure = new ResponceStructure<>();
		responceStructure.setData(productVarient_Dto);
		responceStructure.setMessage("Data succesfully added");
		responceStructure.setStatus(HttpStatus.CREATED.value());
		return responceStructure;
	}

	public ResponceStructure<ProductVariant_Dto> getProductVariantById(long productVariant_id) {
		ProductVariant_Dto productVariant_Dto = productVarient_Dao.getProductVariantById(productVariant_id);
		if (productVariant_Dto != null) {//checking data is present or not
			ResponceStructure<ProductVariant_Dto> responceStructure = new ResponceStructure<>();
			responceStructure.setData(productVariant_Dto);
			responceStructure.setMessage("Data succesfully fetched");
			responceStructure.setStatus(HttpStatus.FOUND.value());
			return responceStructure;
		} else {
			throw new UserdefinedException("Data not found");
		}
	}

	public ResponceStructure<List<ProductVariant_Dto>> getAllProductVariants() {
		List<ProductVariant_Dto> list = productVarient_Dao.getAllProductVariants();
		ResponceStructure<List<ProductVariant_Dto>> responceStructure = new ResponceStructure<>();
		responceStructure.setData(list);
		responceStructure.setMessage("Data succefully fetched");
		responceStructure.setStatus(HttpStatus.FOUND.value());
		return responceStructure;
	}

	public ResponceStructure<ProductVariant_Dto> deleteProductVariantById(long productVairentId) {
		productVarient_Dao.deleteProductVariantById(productVairentId);
		ProductVariant_Dto productVariant_Dto = productVarient_Dao.getProductVariantById(productVairentId);
		if (productVariant_Dto == null) {
			ResponceStructure<ProductVariant_Dto> responceStructure = new ResponceStructure<>();
			responceStructure.setData(null);
			responceStructure.setMessage("Data is succesfully deleted");
			responceStructure.setStatus(HttpStatus.OK.value());
			return responceStructure;
			
		} else {
			ResponceStructure<ProductVariant_Dto> responceStructure = new ResponceStructure<>();
			responceStructure.setData(null);
			responceStructure.setMessage("Data not found");
			responceStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return responceStructure;
		}
	}

	//taking old data's and updating with a new data
	public ResponceStructure<ProductVariant_Dto> updateProductVarient(long productvariantID,
			ProductVariant_Dto productVarient_Dto) {
		ProductVariant_Dto existing_ProductVariant_Dto = productVarient_Dao.getProductVariantById(productvariantID);
		if (existing_ProductVariant_Dto != null) {// checking data present or not
			existing_ProductVariant_Dto.setAdditionalCost(productVarient_Dto.getAdditionalCost());
			existing_ProductVariant_Dto.setId(productVarient_Dto.getId());
			existing_ProductVariant_Dto.setName(productVarient_Dto.getName());
			existing_ProductVariant_Dto.setProduct(productVarient_Dto.getProduct());
			existing_ProductVariant_Dto.setSku(productVarient_Dto.getSku());
			existing_ProductVariant_Dto.setStockCount(productVarient_Dto.getStockCount());
			productVarient_Dao.updateProductVarient(existing_ProductVariant_Dto);

			ResponceStructure<ProductVariant_Dto> responceStructure = new ResponceStructure<>();
			responceStructure.setData(existing_ProductVariant_Dto);
			responceStructure.setMessage("Data succesfully added");
			responceStructure.setStatus(HttpStatus.CREATED.value());
			return responceStructure;
		} else {
			throw new UserdefinedException("Data not found");
		}

	}

}
