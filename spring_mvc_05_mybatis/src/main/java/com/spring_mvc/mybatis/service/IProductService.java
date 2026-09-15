package com.spring_mvc.mybatis.service;

/*
 *  Service는 특정 웹 프레임워크의 제약을 받지 않는 순수 자바 객체로 구성
 *  DAO를 web과 분리 / Controller를 외부객체(DBMS)와의 분리가 목적
 *  Controller와 DAO의 중계자 역할
 */

import java.util.ArrayList;
import com.spring_mvc.mybatis.dto.ProductDTO;

//Controller가 사용할 수 있는 기능
public interface IProductService {
	void insertProduct(ProductDTO prdDto);
	void updateProduct(ProductDTO prdDto);
	void deleteProduct(String prdNo);
	ArrayList<ProductDTO> listAllProduct();
	ProductDTO detailViewProduct(String prdNo);
}
