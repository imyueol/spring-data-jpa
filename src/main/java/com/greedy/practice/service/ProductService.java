package com.greedy.practice.service;



import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.practice.dto.KindDTO;
import com.greedy.practice.dto.ProductDTO;
import com.greedy.practice.entity.Kind;
import com.greedy.practice.entity.Product;
import com.greedy.practice.repository.KindRepository;
import com.greedy.practice.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	private final KindRepository kindRepository;
	private final ModelMapper modelMapper;
	
	public ProductService(ProductRepository productRepository, KindRepository kindRepository, ModelMapper modelMapper) {
		this.productRepository = productRepository;
		this.kindRepository = kindRepository;
		this.modelMapper = modelMapper;
	}

	public ProductDTO findProductByNo(int productNo) {
		
		Product product = productRepository.findById(productNo).orElseThrow(IllegalArgumentException::new);
		
		return modelMapper.map(product, ProductDTO.class);
	}

	public Page<ProductDTO> findProductList(Pageable pageable) {
		
		pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1,
				pageable.getPageSize(),
				Sort.by("productNo").descending());
		
		Page<Product> productList = productRepository.findAll(pageable);
		
		return productList.map(product -> modelMapper.map(product, ProductDTO.class));
	}

	public List<ProductDTO> productTest(Integer productPrice) {
		
		List<Product> productList = productRepository.findByProductPriceGreaterThanEqual(productPrice);
		
		return productList.stream().map(product -> modelMapper.map(product, ProductDTO.class)).collect(Collectors.toList());
	}

	public List<KindDTO> findAllKind() {
		
		List<Kind> kindList = kindRepository.findAllKind();
		return kindList.stream().map(kind -> modelMapper.map(kind, KindDTO.class)).collect(Collectors.toList());
	}
	
	@Transactional
	public void registNewProduct(ProductDTO newProduct) {
		
		productRepository.save(modelMapper.map(newProduct, Product.class));
		
	}
	
	@Transactional
	public void modifyProduct(ProductDTO modifyProduct) {
		
		
		Product foundProduct = productRepository.findById(modifyProduct.getProductNo()).orElseThrow(IllegalArgumentException::new);
		
		foundProduct.setProductName(modifyProduct.getProductName());
		
		log.info("foundProduct : {}", foundProduct);
		
	}
	
	@Transactional
	public void deleteProduct(Integer productNo) {

		productRepository.deleteById(productNo);
		
	}


	





	

}
