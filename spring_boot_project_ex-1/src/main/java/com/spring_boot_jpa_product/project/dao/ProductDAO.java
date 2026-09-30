package com.spring_boot_jpa_product.project.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_boot_jpa_product.project.entity.ProductEntity;
import com.spring_boot_jpa_product.project.repository.ProductRepository;

@Service
public class ProductDAO implements IProductDAO{
	
	ProductRepository prdRepo;
	
	@Autowired
	public ProductDAO(ProductRepository prdRepo) {
		this.prdRepo = prdRepo;
	}

	@Override
	public ArrayList<ProductEntity> listAllProduct() {
		// SQL문 작성 없이 Repository에서 기본으로 제공되는 메서드를 호출
		// entity 매핑 객체 테이블의 모든 레코드 반환하는 메서드 findAll() - List 타입 반환
		// select * from product
		return (ArrayList<ProductEntity>)prdRepo.findAll();
	}

	@Override
	public void insertProduct(ProductEntity dto) {
		prdRepo.save(dto); //기본키 필드값이 동일한 레코드가 없는경우
		
	}

	@Override
	public void updateProduct(ProductEntity dto) {
		prdRepo.save(dto);//기본키 필드값이 동일한 레코드가 있는경우
		
	}

	@Override
	public void deleteProduct(String prdNo) {
		prdRepo.deleteById(prdNo);		
	}

	@Override
	public Optional<ProductEntity> detailViewProduct(String prdNo) {
		//select * from product where prdNo=prdNo
		return prdRepo.findById(prdNo);
	}

	@Override
	public String prdNoCheck(String prdNo) {
		return prdRepo.searchById(prdNo); //개발자가 생성한 메서드
	}

	@Override
	public List<ProductEntity> productSearch(HashMap<String, Object> map) {
		String type = (String)map.get("type");
		String keyword = (String)map.get("keyword");
		return prdRepo.productSearch(type,keyword);
	}

}
