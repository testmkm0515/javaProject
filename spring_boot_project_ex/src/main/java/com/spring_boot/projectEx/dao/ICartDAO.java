package com.spring_boot.projectEx.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot.projectEx.dto.CartDTO;
import com.spring_boot.projectEx.dto.MemberDTO;
import com.spring_boot.projectEx.dto.OrderInfoDTO;

public interface ICartDAO {
	void insertCart(CartDTO dto); //새로운 상품 장바구니에 추가
	int checkPrdInCart(HashMap<String,Object> map);//특정 회원 장바구니에 동일 상품 존재 여부 확인
	void updateQtyInCart(CartDTO dto);//기존 추가된 상품의 수량 변경 - 기존 수량에 새로운 수량을 추가
	ArrayList<CartDTO> cartList(String memId); //특정 회원 장바구니 목록
	//void deleteCart(String cartNo); //장바구니 상품 삭제
	void deleteCart(ArrayList<String> chkArr);//장바구니 상품 삭제
	void updateCart(CartDTO dto);//주문전 장바구니 수량 변경
	
	//주문처리 작업에 필요한 추상 메소드
	public MemberDTO getMemberInfo(String memId); //주문자 정보 추출 메소드
	
	//주문 내역 저장
	public void insertOrderInfo(OrderInfoDTO ordInfoDto); //주문 및 배송 정보
	public void insertOrderProduct(HashMap<String, Object> map); //주문 상품 정보 저장
	
	public void deleteCartAfterOrder(String memId); //주문 완료 후 장바구니 비우기
}
