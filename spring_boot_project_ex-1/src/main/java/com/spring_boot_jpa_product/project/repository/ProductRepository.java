package com.spring_boot_jpa_product.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring_boot_jpa_product.project.entity.ProductEntity;

//@Repository //JpaRepository상속받으면 필요없음
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
	//아무것도 코딩하지 않아도 기본 CRUD 메소드 제공 : findAll(), save():insert/update deleteById(), findById()	
	@Query(value="SELECT p.prdNo FROM ProductEntity p WHERE p.prdNo = :prdNo")
	String searchById(@Param("prdNo") String prdNo);
	
	/*
	 * 		SELECT * FROM product WHERE
			<choose>
				<when test="type != null and type.equals('prdName')">
					prdName LIKE '%' || #{keyword} || '%'
				</when>
				<when test="type != null and type.equals('prdCompany')">
					prdCompany LIKE '%' || #{keyword} || '%'
				</when>			
			</choose>
	 */
	@Query(value="SELECT p FROM ProductEntity p "
			+ "WHERE (:type='prdName' AND p.prdName LIKE CONCAT('%',:keyword,'%')) "
			+ "OR (:type='prdCompany' AND p.prdCompany LIKE CONCAT('%',:keyword,'%'))")
	List<ProductEntity> productSearch(@Param("type")String type, @Param("keyword")String keyword);
}




