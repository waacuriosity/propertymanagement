package com.property.mgt.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.property.mgt.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(String productID);
	
	List<Product> getProductsByCategory(String category);

	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	void addProduct(Product product);
}
