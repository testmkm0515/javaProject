package com.spring_boot_jpa_product.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot_jpa_product.project.dto.ProductDTO;
import com.spring_boot_jpa_product.project.service.ProductService;


@Controller
public class ProductController {
	
	ProductService productService;
	
	// DI 설정
	@Autowired		
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	// 시작 시 index 페이지 열기
	@RequestMapping("/") 
	public String viewIndex() {
		return "index"; // index.jsp 파일의 이름 반환
	}


	// 전체 상품 조회
	// ProductService 클래스의 listAllProduct() 메소드 호출하기 위해서는 객체 필요
	// @Autowired 어노테이션 사용해서 DI 설정 필요
	@RequestMapping("/product/listAllProduct")
	public String  listAllProduct(Model model) {
		// (1) ProductService 클래스의 listAllProduct() 호출해서 결과 받아옴
		ArrayList<ProductDTO> prdList = productService.listAllProduct();
		
		// (2) Model 설정
		model.addAttribute("prdList", prdList);
		
		// (3) 뷰 페이지 반환
		return "product/productListView";
	}
	
	// 상품 등록 폼 열기
	@RequestMapping("/product/newProductForm")
	public String newProductForm() {
		return "product/newProductForm";
	}

	// 상품 등록 
	// 폼에 입력된 데이터를 ProductVO에 저장
	// ProductService의 insertProduct() 메소드 호출하면서 VO 전달
	// DB 저장 후 '전체 도서 조회' 화면으로 포워딩 : redirect
	@RequestMapping("/product/insertProduct")
	public String insertProduct(ProductDTO dto) {
		productService.insertProduct(dto);		
		return "redirect:/product/listAllProduct";		
	}
	
	// 상품 상세 정보 조회
	@RequestMapping("/product/detailViewProduct/{prdNo}")
	public String detailViewProduct(@PathVariable String prdNo, Model model) {
		// 서비스에게 상품번호 전달하고, 해당 상품 데이터 받아오기
		ProductDTO prd = productService.detailViewProduct(prdNo);
		
		// 뷰 페이지에 출력하기 위해 Model 설정
		model.addAttribute("prd", prd);
		
		return "product/productDetailView";
	}
	
	// 상품 정보 수정 화면 열기
	// 상품 정보를 수정하기 위해 먼저 상품 정보를 출력 : 상세 정보 출력 (입력 폼에)
	// detailViewProduct() 사용해서 정보 먼저 출력
	@RequestMapping("/product/updateProductForm/{prdNo}")
	public String updateProductForm(@PathVariable String prdNo, Model model) {
		// 서비스에게 상품번호 전달하고, 해당 상품 데이터 받아오기
		ProductDTO prd = productService.detailViewProduct(prdNo);
		
		// 뷰 페이지에 출력하기 위해 Model 설정
		model.addAttribute("prd", prd);
		
		return "product/updateProductForm"; // 폼에 데이터 출력
	}
	
	// 수정된 데이터 받아서 DB에 저장
	@RequestMapping("/product/updateProduct")
	public String updateProduct(ProductDTO dto) {
		productService.updateProduct(dto);		
		return "redirect:/product/listAllProduct";
	}
	
	// 상품 정보 삭제 
	// 상품번호 전달 받아서 서비스에게 전달 -> dao -> Mapper -> DB에서 삭제
	// 삭제 후 전체 상품 정보 조회 화면으로 이동 : 포워딩
	@RequestMapping("/product/deleteProduct/{prdNo}")
	public String deleteProduct(@PathVariable String prdNo) {
		productService.deleteProduct(prdNo);	
		return "redirect:/product/listAllProduct";		
	}
	
	// 상품번호 중복 확인  방법1 : ajax 사용 post 방식
	@ResponseBody
	@RequestMapping("/product/prdNoCheck")
	public String prdNoCheck(@RequestParam("prdNo") String prdNo) {
		// 서비스 호출해서 DB에 해당 상품번호가 존재 여부 확인
		// 존재하면 상품번호를 받아올 것임
		String prdNo_result = productService.prdNoCheck(prdNo);
		
		String result = "available";
		if(prdNo_result != null) // 상품번호가 존재한다면
			result = "not_available";
		
		return result;		
	}
	
	
	
	// 상품 검색 폼 열기 /product/productSearchForm1'
	@RequestMapping("/product/productSearchForm1")
	public String productSearchForm1() {
		return "product/productSearchForm1";
	}
	
	// 상품 검색 방법1
	// 검색 조건과 keyword 전달 받아서 서비스에게 전달하고 
	// DB에서 검색 결과를 ArrayList로 받아서 Ajax로 전달	
//	@ResponseBody
//	@RequestMapping("/product/productSearch1")
//	public ArrayList<ProductDTO> productSearch1(@RequestParam HashMap<String, Object> param) {
//		ArrayList<ProductDTO> prdList = productService.productSearch(param);		
//		return prdList;
//	}
	
	// 상품 검색 방법2
	@ResponseBody
	@RequestMapping("/product/productSearch1")
	public List<ProductDTO> productSearch1(@RequestParam HashMap<String, Object> param) {
		List<ProductDTO> prdList = productService.productSearch(param);		
		return prdList;
	}

	

}








