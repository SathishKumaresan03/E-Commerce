package com.sathish.ECommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sathish.ECommerce.Dto.Product_Dto;

@Component
public interface ProductRepository extends JpaRepository<Product_Dto, Long> {
	List<Product_Dto> findByNameContainingOrDescriptionContaining(String name, String description);
    List<Product_Dto> findByVariants_NameContaining(String variantName);

	
}
