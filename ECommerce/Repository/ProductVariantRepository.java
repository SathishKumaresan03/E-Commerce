package com.sathish.ECommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sathish.ECommerce.Dto.ProductVariant_Dto;

@Component
public interface ProductVariantRepository extends JpaRepository<ProductVariant_Dto, Long> {

}
