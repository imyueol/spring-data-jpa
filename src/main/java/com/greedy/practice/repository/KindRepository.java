package com.greedy.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greedy.practice.entity.Kind;

public interface KindRepository extends JpaRepository<Kind, Integer>{
	
	@Query(value="SELECT PRODUCT_CATEGORY, CATEGORY_NAME FROM TBL_KIND ORDER BY PRODUCT_CATEGORY ASC"
			, nativeQuery = true)
	List<Kind> findAllKind();

}
