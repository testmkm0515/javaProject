package com.spring_boot.projectEx.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.spring_boot.projectEx.dao.ICartDAO;
import com.spring_boot.projectEx.dto.CartDTO;

@Service
@Primary
public class CartService implements ICartService {
	
	@Autowired
	@Qualifier("ICartDAO")	
	ICartDAO dao;

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

	@Override
	public void deleteCart(String cartNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCart(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

}
