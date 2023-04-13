package com.greedy.practice.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greedy.practice.common.Pagenation;
import com.greedy.practice.common.PagingButtonInfo;
import com.greedy.practice.dto.KindDTO;
import com.greedy.practice.dto.ProductDTO;
import com.greedy.practice.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {
	
    private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/{productNo}")
	public String findProductByNo(@PathVariable int productNo, Model model) {
		
		log.info("producNo : {}", productNo);
		
		ProductDTO product = productService.findProductByNo(productNo);
		
		log.info("product : {}", product);
		
		model.addAttribute("productList", product);
		
		
		return "product/list";
	}
	
	@GetMapping("/lists")
	public String findProductList(@PageableDefault Pageable pageable, Model model) {
		
		Page<ProductDTO> productList = productService.findProductList(pageable);
		
		PagingButtonInfo paging = Pagenation.getPagingButtonInfo(productList);
		
		model.addAttribute("paging", paging);
		model.addAttribute("productList", productList);
		
		return "product/lists";
	}
	
	@GetMapping("/querymethod")
	public void queryMethodPage() {}
	
	@GetMapping("/test")
	public String productTest(@RequestParam Integer productPrice, Model model) {
		
		List<ProductDTO> productList = productService.productTest(productPrice);
		
		log.info("productList : {}", productList);
		
		model.addAttribute("productList", productList);
		
		return "product/list";
		
	}
	
	@GetMapping("/regist")
	public void registPage() {}
	
	@GetMapping(value="/kind", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<KindDTO> findKindList(){
		
		return productService.findAllKind();
	}
	
	@PostMapping("/regist")
	public String registNewProduct(@ModelAttribute ProductDTO newProduct) {
		
		productService.registNewProduct(newProduct);
		
		return "redirect:/product/lists";
	}
	
	@GetMapping("/modify")
	public void modifyPage() {}
	
	@PostMapping("/modify")
	public String modifyProduct(ProductDTO modifyProduct) {
		
		log.info("modifyProduct : {}", modifyProduct);
		
		productService.modifyProduct(modifyProduct);
		
		return "redirect:/product/" + modifyProduct.getProductNo();
	}
	
	@GetMapping("/delete")
	public void deletePage() {}
	
	@PostMapping("/delete")
	public String deleteProduct(@RequestParam Integer productNo) {
		
		productService.deleteProduct(productNo);
		
		return "redirect:/product/lists";
	}
	
	
	

}
