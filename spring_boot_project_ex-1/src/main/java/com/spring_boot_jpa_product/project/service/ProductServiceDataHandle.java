package com.spring_boot_jpa_product.project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_boot_jpa_product.project.dao.ProductDAO;
import com.spring_boot_jpa_product.project.entity.ProductEntity;

@Service
public class ProductServiceDataHandle implements IProductServiceDataHandle {
	ProductDAO dao;
	
	@Autowired
	public ProductServiceDataHandle(ProductDAO dao) {
		this.dao = dao;
	}

	@Override
	public ArrayList<ProductEntity> listAllProduct() {
		return dao.listAllProduct();
	}

	@Override
	public void insertProduct(ProductEntity dto) {
		dao.insertProduct(dto);		
	}

	@Override
	public void updateProduct(ProductEntity dto) {
		dao.updateProduct(dto);		
	}

	@Override
	public void deleteProduct(String prdNo) {
		dao.deleteProduct(prdNo);		
	}

	@Override
	public Optional<ProductEntity> detailViewProduct(String prdNo) {
		Optional<ProductEntity> entity = dao.detailViewProduct(prdNo);
		return entity;
	}

	@Override
	public String prdNoCheck(String prdNo) {
		return dao.prdNoCheck(prdNo);
	}

	@Override
	public List<ProductEntity> productSearch(HashMap<String, Object> map) {
		return dao.productSearch(map);
	}
	
}
