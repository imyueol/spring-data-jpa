package com.greedy.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greedy.practice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findByProductPriceGreaterThanEqual(Integer productPrice);
	

}
