package com.spring_boot_jpa_product.project.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.spring_boot_jpa_product.project.entity.ProductEntity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Data
@Getter
//@Setter
//@ToString
@Builder
public class ProductDTO {
	private String prdNo;
	private String prdName;
	private int prdPrice;
	private String prdCompany;
	private int prdStock;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date prdDate;
	
	//Entity객체를 전달받아서 -> DTO 객체 변환시 사용할 메소드 static 으로 추가
	
	public static ProductDTO toDto(ProductEntity entity) {
		return ProductDTO.builder()
				.prdNo(entity.getPrdNo()) //entity의 prdNo를 추출해서 ProductDTOBuilder 클래스 필드 prdNo에 저장
				.prdName(entity.getPrdName())
				.prdPrice(entity.getPrdPrice())
				.prdCompany(entity.getPrdCompany())
				.prdStock(entity.getPrdStock())
				.prdDate(entity.getPrdDate())
				.build(); //build() 반환타입이 ProductDTO타입이고 작업내용은 매개변수가 있는 생성자 호출 ProductDTO객체 생성 후 반환
	}
	
}

















