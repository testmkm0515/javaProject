package com.spring_boot.projectEx.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot.projectEx.dto.CartDTO;
import com.spring_boot.projectEx.dto.MemberDTO;
import com.spring_boot.projectEx.dto.OrderInfoDTO;

public interface ICartService {
	void insertCart(CartDTO dto); //새로운 상품 장바구니에 추가
	int checkPrdInCart(CartDTO dto);//특정 회원 장바구니에 동일 상품 존재 여부 확인
	void updateQtyInCart(CartDTO dto);//기존 추가된 상품의 수량 변경
	ArrayList<CartDTO> cartList(String memId); //특정 회원 장바구니 목록
	//void deleteCart(String cartNo); //장바구니 상품 삭제
	void deleteCart(ArrayList<String> noArr); //장바구니 상품 삭제
	void updateCart(CartDTO dto);
	
	//주문처리 작업에 필요한 추상 메소드
	public MemberDTO getMemberInfo(String memId); //주문자 정보 추출 메소드
	public void insertOrderInfo(OrderInfoDTO ordInfoDto); //주문 및 배송 정보

}
