package com.spring_boot.projectEx.service;

import java.util.ArrayList;

import com.spring_boot.projectEx.dto.ProductDTO;

public interface IProductService {
	ArrayList<ProductDTO> listCtgProduct(String ctgId);
	
	//상품 CRUD는 spring_boot_mybatis 프로젝트에서 진행함
	ProductDTO detailViewProduct(String prdNo);
}
