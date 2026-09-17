package com.spring_mvc.mybatis.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_mvc.mybatis.dto.ProductDTO;
import com.spring_mvc.mybatis.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}	
	
	@RequestMapping("/product/listAllProduct")
	public String listAllProduct(Model model) {
		ArrayList<ProductDTO> prdList = service.listAllProduct();
		model.addAttribute("prdList", prdList);
		return "product/productListView";
	}
	
	@RequestMapping("/product/newProductForm")
	public String newProductForm() {
		return "product/newProductForm";
	}
	
	/*
	 * 파라미터로 폼데이터가 전달
	 * command 객체를 활용해서 저장 - command 객체를 통해 비지니스 로직 처리
	 * 새로운 상품이 등록되면 상품정보 조회로 redirect
	 * 현재 요청에 대한 응답처리하고 재요청을 클라이언트가 진행하게끔 구성
	 */
	@RequestMapping("/product/insertProduct")
	public String insertProduct(ProductDTO dto) {
		service.insertProduct(dto);//완료신호 반환되면 저장되었다는 신호 이므로 다음 내용 진행
		return "redirect:/product/listAllProduct";
	}
	
	@RequestMapping("/product/detailViewProduct/{prdNo}")
	public String detailViewProduct(@PathVariable String prdNo, Model model) {
		ProductDTO dto = service.detailViewProduct(prdNo);
		model.addAttribute("dto", dto );
		return "product/productDetailView";
	}
	
	@RequestMapping("/product/updateProductForm/{prdNo}")
	public String updateProductForm(@PathVariable String prdNo, Model model) {
		ProductDTO dto = service.detailViewProduct(prdNo);
		model.addAttribute("prd", dto);
		return "product/updateProductForm";
	}
	
	@RequestMapping("/product/updateProduct")
	public String updateProduct(ProductDTO dto) {
		//System.out.println(dto.getPrdNo());
		service.updateProduct(dto);
		return "redirect:/product/listAllProduct";
	}
	
	@RequestMapping("/product/deleteProduct/{prdNo}")
	public String deleteProduct(@PathVariable String prdNo) {
		service.deleteProduct(prdNo);
		return "redirect:/product/listAllProduct";
	}
	
	//상품번호 중복 확인 : post,get - 파라미터 전달
	//rest 형식으로 반환
	@ResponseBody
	@RequestMapping("/product/prdNoCheck")
	public String prdNoCheck(@RequestParam("prdNo") String prdNo) {
		String result = service.prdNoCheck(prdNo); //상품번호 중복 체크 service에서 진행 결과만 반환
		System.out.println(result);
		return result;
	}
	
	//상품번호 중복 확인2 : get - url data 전달
	//rest 형식으로 반환
	@ResponseBody
	@RequestMapping("/product/prdNoCheck1/{prdNo}")
	public String prdNoCheck1(@PathVariable String prdNo) {
		String result = service.prdNoCheck(prdNo); //상품번호 중복 체크 service에서 진행 결과만 반환
		System.out.println(result);
		return result;
	}
	
	//상품번호 중복 확인3 : post - request Body를 통해 data 전달
	//rest 형식으로 반환
	@ResponseBody
	@RequestMapping("/product/prdNoCheck4")
	public String prdNoCheck4(@RequestBody String prdNo) {
		String result = service.prdNoCheck(prdNo); //상품번호 중복 체크 service에서 진행 결과만 반환
		System.out.println(result);
		return result;
	}	
	
	//상품번호 중복 확인4 : axios get의 요청
	//axios는 응답방식을 서버에게 요청하게 됨 스프링컨테이너가 해당 요청을 처리할때 data 필드에 반환값을 담아서 전송
	//rest 형식으로 반환
	@ResponseBody
	@RequestMapping("/product/prdNoCheck5/{prdNo}")
	public String prdNoCheck5(@PathVariable String prdNo) {
		String result = service.prdNoCheck(prdNo); //상품번호 중복 체크 service에서 진행 결과만 반환
		System.out.println(result);
		return result;
	}	
	
	//상품번호 중복 확인5 : axios post의 요청시 전달되는 data는 key:value 타입으로 전달, 컨트롤러에서는 k:v 타입을 저장할 수 있는 객체를 활용해야 함
	//header의 body 통해 전달
	@ResponseBody
	@RequestMapping("/product/prdNoCheck6")
	public String prdNoCheck6(@RequestBody HashMap<String,String> map) {
		String prdNo = map.get("prdNo");
		String result = service.prdNoCheck(prdNo); //상품번호 중복 체크 service에서 진행 결과만 반환
		System.out.println(result);
		return result;
	}	
	
	////////////////////////////////////////////////////////
	// 상품 검색 기능
	
	// 상품 검색 폼 요청
	@RequestMapping("/product/productSearchForm1")
	public String viewProductSearchForm1() {
		return "product/productSearchForm1";
	}
	
	// 상품 검색 메소드 1 - ArrayList 객체를 스프링컨테이너에게 반환하면 컨테이너는 json 형식으로 변환 후 
	// 클라이언트에게 전송 : jackson-databind 의존객체 필요
	@ResponseBody
	@RequestMapping("/product/productSearch1")
	public ArrayList<ProductDTO> productSearch1(@RequestParam HashMap<String, Object> map){
	/*public ArrayList<ProductDTO> productSearch1(@RequestParam String type,
									            @RequestParam String keyword){*/
		ArrayList<ProductDTO> prdList = service.productSearch(map);		
		return prdList;
	}

	// 상품 검색 폼 요청2
	@RequestMapping("/product/productSearchForm2")
	public String viewProductSearchForm2() {
		return "product/productSearchForm2";
	}
	
	// 상품 검색 메소드 2 - view 페이지 반환
	@RequestMapping("/product/productSearch2")
	public String productSearch2(@RequestParam HashMap<String, Object> map, Model model){
	/*public ArrayList<ProductDTO> productSearch1(@RequestParam String type,
									            @RequestParam String keyword){*/
		ArrayList<ProductDTO> prdList = service.productSearch(map);	
		model.addAttribute("prdList", prdList);
		return "product/productSearchResultView";
	}
	
	// 상품 검색 폼 요청3
	@RequestMapping("/product/productSearchForm3")
	public String viewProductSearchForm3() {
		return "product/productSearchForm3";
	}
	
}

























