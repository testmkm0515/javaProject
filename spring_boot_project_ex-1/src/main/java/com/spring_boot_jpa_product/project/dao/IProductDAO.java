package com.spring_boot_jpa_product.project.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.spring_boot_jpa_product.project.dto.ProductDTO;
import com.spring_boot_jpa_product.project.entity.ProductEntity;

public interface IProductDAO {

	// 전체 상품 조회 : DAO에게 요청 -> DB에서 전체 상품(VO 여러 개(ArrayList)) 찾아서 반환
	public ArrayList<ProductEntity> listAllProduct(); 
	
	// 상품 정보 등록 : insertProduct() : 1개의 상품 정보를 전달 받아서 DAO에게 전달 -> DB에 저장. 끝(반환 없음)
	public void insertProduct(ProductEntity dto);
	
	// 상품 정보 수정 : updateProduct() : 1개의 수정된 상품 정보를 전달 받아서 DAO에게 전달
	//-> DB에 해당 상품의 수정된 값 저장. 끝(반환 없음)
	public void updateProduct(ProductEntity dto);
	
	// 상품 정보 삭제 : deleteProduct() : 1개의 상품 정보(기본키만 필요)를 전달 받아서 DAO에게 전달
	// -> DB에서 해당 상품 삭제. 끝(반환 없음)
	public void deleteProduct(String prdNo); 
	
	// 상세 상품 정보 조회 : detailViewProduct() : 1개의 상품 정보(기본키만 필요)를 전달 받아서 DAO에게 전달
	// 1개 entity 조회하는 jpa repo method는 반환타입이 Optional<T> 타입으로 반환됨
	public Optional<ProductEntity> detailViewProduct(String prdNo);
	
	//상품번호 중복 체크 
	public String prdNoCheck(String prdNo); // 상품번호 전달해서 이 번호가 존재하는지 확인
	
	// 상품 검색 방법1
	// public ArrayList<ProductDTO> productSearch(HashMap<String, Object> map);
	
	// 상품 검색 방법2
	public List<ProductEntity> productSearch(HashMap<String, Object> map);
}
