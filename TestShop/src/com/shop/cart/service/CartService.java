package com.shop.cart.service;

import java.util.List;

import com.shop.cart.vo.CartVO;

public interface CartService {

	List<CartVO> selectCartList();
	CartVO selectCart(String id);
	public int insertCart(CartVO vo);
	public int updateCart(CartVO vo);
	public int deleteCart(CartVO vo);
}
