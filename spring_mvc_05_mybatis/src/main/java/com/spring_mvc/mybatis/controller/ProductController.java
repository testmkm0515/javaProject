package com.spring_mvc.mybatis.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mvc.mybatis.dto.ProductDTO;
import com.spring_mvc.mybatis.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	@RequestMapping("/product/listAllProduct")
	public String listAllProduct(Model model) {
		ArrayList<ProductDTO> prdList = service.listAllProduct();
		model.addAttribute("prdList", prdList);
		return "product/productListView";
	}
	
	@RequestMapping("/product/newProductForm")
	public String newProductForm() {
		return "product/newProductForm";
	}
	
	/*
	 * 파라미터로 폼데이터가 전달
	 * command 객체를 활용해서 저장 - command 객체를 통해 비지니스 로직 처리
	 * 새로운 상품이 등록되면 상품정보 조회로 redirect
	 * 현재 요청에 대한 응답처리하고 재요청을 클라이언트가 진행하게끔 구성
	 */
	@RequestMapping("/product/insertProduct")
	public String insertProduct(ProductDTO dto) {
		service.insertProduct(dto);//완료신호 반환되면 저장되었다는 신호 이므로 다음 내용 진행
		return "redirect:/product/listAllProduct";
	}
	
	@RequestMapping("/product/detailViewProduct/{prdNo}")
	public String detailViewProduct(@PathVariable String prdNo, Model model) {
		ProductDTO dto = service.detailViewProduct(prdNo);
		model.addAttribute("dto", dto );
		return "product/productDetailView";
	}
	
	@RequestMapping("/product/updateProductForm/{prdNo}")
	public String updateProductForm(@PathVariable String prdNo, Model model) {
		ProductDTO dto = service.detailViewProduct(prdNo);
		model.addAttribute("prd", dto);
		return "product/updateProductForm";
	}
	
	@RequestMapping("/product/updateProduct")
	public String updateProduct(ProductDTO dto) {
		//System.out.println(dto.getPrdNo());
		service.updateProduct(dto);
		return "redirect:/product/listAllProduct";
	}
	
	@RequestMapping("/product/deleteProduct/{prdNo}")
	public String deleteProduct(@PathVariable String prdNo) {
		service.deleteProduct(prdNo);
		return "redirect:/product/listAllProduct";
	}
	
}

























