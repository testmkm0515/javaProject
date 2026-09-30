package com.spring_boot_jpa_product.project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_boot_jpa_product.project.dto.ProductDTO;
import com.spring_boot_jpa_product.project.entity.ProductEntity;

//DTO<->ENTITY 변환
//              DTO<->ENTITY
//컨트롤러->서비스->DataHandle서비스->DAO->REPO->DB
//컨트롤러<-서비스<-DataHandle서비스<-DAO<-REPO<-DB
@Service
public class ProductService implements IProductService {

	ProductServiceDataHandle productServiceDataHandle;
	
	@Autowired
	public ProductService(ProductServiceDataHandle productServiceDataHandle ) {
		this.productServiceDataHandle = productServiceDataHandle;
	}
	
	//DataHandle 서비스에서 entity 타입으로 반환
	@Override
	public ArrayList<ProductDTO> listAllProduct() {
		ArrayList<ProductEntity> entityList = productServiceDataHandle.listAllProduct(); //db rs 저장되어 있음
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		
		//entityList에 저장되어있는 레코드(entity)를 dto로 변환해서 list에 저장
		for(ProductEntity entity: entityList) {
			ProductDTO dto = ProductDTO.toDto(entity);
			list.add(dto);
		}
		return list;
	}

	@Override
	public void insertProduct(ProductDTO dto) {
		ProductEntity e = ProductEntity.toEntity(dto);
		productServiceDataHandle.insertProduct(e);		
	}

	//entity <->dto 변환 코드 활용해서 datahandle 서비스의 메소드 호출코드 작성

	@Override
	public void updateProduct(ProductDTO dto) {
		ProductEntity entity = ProductEntity.toEntity(dto);
		productServiceDataHandle.updateProduct(entity);		
	}

	@Override
	public void deleteProduct(String prdNo) {
		productServiceDataHandle.deleteProduct(prdNo);		
	}

	@Override
	public ProductDTO detailViewProduct(String prdNo) {
		Optional<ProductEntity> entity = productServiceDataHandle.detailViewProduct(prdNo);
		ProductDTO dto = ProductDTO.toDto(entity.get());
		return dto;
	}

	@Override
	public String prdNoCheck(String prdNo) {
		String res = productServiceDataHandle.prdNoCheck(prdNo);
		return res;
	}

	@Override
	public List<ProductDTO> productSearch(HashMap<String, Object> map) {
		List<ProductEntity> entityList =  productServiceDataHandle.productSearch(map);
		List<ProductDTO> dtoList = new ArrayList<ProductDTO>();
		for(ProductEntity e : entityList) {
			dtoList.add(ProductDTO.toDto(e));
		}
		return dtoList;
	}

}
