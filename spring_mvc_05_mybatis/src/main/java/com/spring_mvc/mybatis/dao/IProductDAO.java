package com.spring_mvc.mybatis.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_mvc.mybatis.dto.ProductDTO;

public interface IProductDAO {
	void insertProduct(ProductDTO prdDto);
	void updateProduct(ProductDTO prdDto);
	void deleteProduct(String prdNo);
	ArrayList<ProductDTO> listAllProduct();
	ProductDTO detailViewProduct(String prdNo);	//매개변수와 반환값이 있는 메서드
	String prdNoCheck(String prdNo);
	ArrayList<ProductDTO> productSearch(HashMap<String, Object> map);//상품검색
}
