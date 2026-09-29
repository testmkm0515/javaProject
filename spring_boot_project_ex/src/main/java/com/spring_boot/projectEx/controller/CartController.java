package com.spring_boot.projectEx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot.projectEx.dto.CartDTO;
import com.spring_boot.projectEx.dto.MemberDTO;
import com.spring_boot.projectEx.dto.OrderInfoDTO;
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
	
	//장바구니 목록 삭제 요청 처리
	@ResponseBody
	@PostMapping("/product/deleteCart")
	public int deleteCart(@RequestParam("delPrd") ArrayList<String> chkArr) {
		int result=0;
		if(chkArr!=null) {
//			for(String cartNo:chkArr) {
//				cartService.deleteCart(cartNo);
//			}
			cartService.deleteCart(chkArr);
			result =1;
		}
		return result;
	}
	
	//주문서 작성요청 처리
	@PostMapping("/product/orderForm")
	public String orderForm(@RequestParam int[] cartNo,
						    @RequestParam int[] cartQty,
						    Model model,
						    HttpSession session) {
		//주문자 정보위해 memId 추출
		String memId = (String)session.getAttribute("sid");
		
		//주문수량이 변경되었을 수 있으므로 수량 update를 먼저 진행
		for(int i=0; i<cartNo.length; i++) {
			CartDTO dto = new CartDTO();
			dto.setCartNo(cartNo[i]);
			dto.setCartQty(cartQty[i]);
			cartService.updateCart(dto);
		}
		
		//주문서에 출력할 회원 정보 추출
		MemberDTO mem = cartService.getMemberInfo(memId);
		String[] hp = (mem.getMemHp()).split("-");
		model.addAttribute("memDTO", mem);
		model.addAttribute("hp1",hp[0]);
		model.addAttribute("hp2",hp[1]);
		model.addAttribute("hp3",hp[2]);
		
		//주문서에 출력할 장바구니 목록
		ArrayList<CartDTO> cartList = cartService.cartList(memId);
		model.addAttribute("cartList", cartList);
		
		return "product/orderForm";
	}
	
	//주문완료 요청 처리
	@PostMapping("/product/orderComplete")
	public String orderInsert(OrderInfoDTO ordInfoDto,
							  @RequestParam String hp1,
							  @RequestParam String hp2,
							  @RequestParam String hp3,
							  HttpSession session,
							  Model model) {
		//전화번호 설정
		String hp = hp1 + "-" + hp2 + "-" + hp3;
		ordInfoDto.setOrdRcvPhone(hp);
		
		//memId 설정
		ordInfoDto.setMemId((String)session.getAttribute("sid"));
		
		//주문번호 생성 및 설정
		//주문번호 생성 : 오늘날짜시분초 _ 랜덤숫자 4개
		long timeNum = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMddHHmmss");
		String srtTime = dayTime.format(new Date(timeNum));
		
		String rNum = "";
		for(int i=1;i<=4;i++) {
			rNum += (int)(Math.random()*10);
		}
		String ordNo = srtTime+"_"+rNum;
		ordInfoDto.setOrdNo(ordNo);
		
		cartService.insertOrderInfo(ordInfoDto);
		
		model.addAttribute("ordNo", ordNo);
		
		return "product/orderCompleteView";
	}
}
















































