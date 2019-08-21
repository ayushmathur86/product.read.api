package com.adidas.products.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.adidas.products.model.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, String> {

}
