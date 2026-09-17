package com.spring_mvc.mybatis.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring_mvc.mybatis.dto.ProductDTO;
import com.spring_mvc.mybatis.service.ProductService;

/*
 * 이 클래스는 rest api를 구현하는 클래스(컨트롤러)
 * 모든 메소드에 @ResponseBody를 첨부하는것과 같음 
 */
@RestController
public class ProductRestController {
	@Autowired
	ProductService service;
	
	@RequestMapping("/product/productSearch3")
	public ArrayList<ProductDTO> productSearch1(@RequestParam HashMap<String, Object> map){
		ArrayList<ProductDTO> prdList = service.productSearch(map);		
		return prdList;
	}
}
