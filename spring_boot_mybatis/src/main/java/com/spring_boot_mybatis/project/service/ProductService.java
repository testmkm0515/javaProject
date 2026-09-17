package com.spring_boot_mybatis.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_boot_mybatis.project.dao.IProductDAO;
import com.spring_boot_mybatis.project.dto.ProductDTO;

//해당 클래스가 Service Component라는걸 Spring 컨테이너에게 알림
@Service
public class ProductService implements IProductService {
	//MyBatis 사용하는 경우 인터페이스를 통한 주입
	@Autowired
	@Qualifier("IProductDAO")
	IProductDAO dao;
	
	@Override
	public ArrayList<ProductDTO> productSearch(HashMap<String, Object> map) {
		
		return dao.productSearch(map);
	}

	@Override
	public String prdNoCheck(String prdNo) {
		String res = dao.prdNoCheck(prdNo);
		String result="available";
		if(res!=null) {
			result="no_available";
		}
		return result;
	}

	@Override
	public void insertProduct(ProductDTO prdDto) {		
		dao.insertProduct(prdDto);
	}

	@Override
	public void updateProduct(ProductDTO prdDto) {
		dao.updateProduct(prdDto);		
	}

	@Override
	public void deleteProduct(String prdNo) {
		dao.deleteProduct(prdNo);
		
	}

	@Override
	public ArrayList<ProductDTO> listAllProduct() {		
		return dao.listAllProduct();
	}

	@Override
	public ProductDTO detailViewProduct(String prdNo) {
		return dao.detailViewProduct(prdNo);
	}

}
