package com.spring_boot_react.project.service;
import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot_react.project.dto.ProductDTO;



//Controller가 사용할 수 있는 기능
public interface IProductService {
	void insertProduct(ProductDTO prdDto);
	void updateProduct(ProductDTO prdDto);
	void deleteProduct(String prdNo);
	ArrayList<ProductDTO> listAllProduct();
	ProductDTO detailViewProduct(String prdNo);
	String prdNoCheck(String prdNo);
	ArrayList<ProductDTO> productSearch(HashMap<String, Object> map);
}
