package com.spring_boot.projectEx.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring_boot.projectEx.dto.ProductDTO;
import com.spring_boot.projectEx.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService service;
	
	//카테고리별 상품 조회
	@GetMapping("/product/productListCtg/{ctgId}")
	public String productCtgList(@PathVariable String ctgId, Model model) {
		ArrayList<ProductDTO> prdList = service.listCtgProduct(ctgId);
		model.addAttribute("prdList", prdList);
		
		return "product/productCtgListView";
	}

	//상품 상세정보 조회요청 처리 완성->view까지 모두 구성
	//레코드 컬럼 모두 표현되도록 구성 - 이미지 크기는 구별 가능하도록 설정
	@GetMapping("/product/detailViewProduct/{prdNo}")
	public String detailViewProduct(@PathVariable String prdNo, Model model) {
		ProductDTO prd = service.detailViewProduct(prdNo);
		model.addAttribute("prd", prd);
		return "product/productDetailView";
	}
}













