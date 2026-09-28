package com.spring_boot.projectEx.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring_boot.projectEx.dto.CartDTO;
import com.spring_boot.projectEx.service.CartService;
import com.spring_boot.projectEx.service.ICartService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	
	@Autowired
	//@Qualifier("CartService")
	CartService cartService;
	
	@PostMapping("/product/insertCart")
	public String insertCart(CartDTO dto, HttpSession session) {
		//command 객체 통해 파라미터 대입(prdNo, cartQty), session 통해 memId값은 대입
		String memId = (String)session.getAttribute("sid"); //sid 속성에 memId 저장
		dto.setMemId(memId);
		
		//동일 상품이 존재하는지 확인
		int res = cartService.checkPrdInCart(dto);
		
		if(res==0) {
			cartService.insertCart(dto);
		}else {
			cartService.updateQtyInCart(dto);  //동일 상품 있으면 수량만 변경하도록(기존 수량에 추가)
		}		
		return "redirect:/product/cartList";		
	}
	
	//장바구니 목록보기 요청 처리
	@GetMapping("/product/cartList")
	public String cartList(Model model, HttpSession session) {
		String memId = (String)session.getAttribute("sid");
		ArrayList<CartDTO> cartList = cartService.cartList(memId);
		model.addAttribute("cartList", cartList);
		return "cart/cartListView";
	}
}















