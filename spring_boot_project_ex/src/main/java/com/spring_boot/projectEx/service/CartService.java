package com.spring_boot.projectEx.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.spring_boot.projectEx.dao.ICartDAO;
import com.spring_boot.projectEx.dto.CartDTO;
import com.spring_boot.projectEx.dto.MemberDTO;
import com.spring_boot.projectEx.dto.OrderInfoDTO;

@Service
@Primary
public class CartService implements ICartService {
	@Autowired
	@Qualifier("ICartDAO")	
	ICartDAO dao;
	
	@Override
	public MemberDTO getMemberInfo(String memId) {
		return dao.getMemberInfo(memId);
	}

	@Override
	public void insertOrderInfo(OrderInfoDTO ordInfoDto) {
		// 1. 주문정보 order_info 테이블에 저장하도록 
		dao.insertOrderInfo(ordInfoDto);
		System.out.println("orderInfo 저장 완료");
		
		// 2. 주문 상품 정보 order_product 테이블에 저장
		// orderNo와 cart테이블에서 주문상품 목록을 추출하도록 memId를 전달
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ordNo", ordInfoDto.getOrdNo());
		map.put("memId", ordInfoDto.getMemId());
		dao.insertOrderProduct(map);
		System.out.println("orderProduct 저장 완료");
		
		// 3. 주문완료 후 주문회원에 대한 cart 테이블 비우기
		dao.deleteCartAfterOrder(ordInfoDto.getMemId());
		System.out.println("cart 삭제 완료");
	}

	@Override
	public void insertCart(CartDTO dto) {
		dao.insertCart(dto);		
	}

	@Override
	public int checkPrdInCart(CartDTO dto) {
		// dao의 기능 호출 위해 hashmap 구성
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("prdNo", dto.getPrdNo());
		map.put("memId", dto.getMemId());
		return dao.checkPrdInCart(map);
	}

	@Override
	public void updateQtyInCart(CartDTO dto) {
		dao.updateQtyInCart(dto);		
	}

	@Override
	public ArrayList<CartDTO> cartList(String memId) {
		return dao.cartList(memId);
	}

//	@Override
//	public void deleteCart(String cartNo) {
//		dao.deleteCart(cartNo);
//	}

	@Override
	public void deleteCart(ArrayList<String> chkArr) {		
		dao.deleteCart(chkArr);
	}
	

	@Override
	public void updateCart(CartDTO dto) {
		dao.updateCart(dto);		
	}



}
