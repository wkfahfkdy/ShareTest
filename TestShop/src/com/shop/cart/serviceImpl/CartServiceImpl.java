package com.shop.cart.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.cart.service.CartService;
import com.shop.cart.vo.CartVO;
import com.shop.common.DAO;

public class CartServiceImpl extends DAO implements CartService {

	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	public void close() {

		try {

			if (rs != null)rs.close();
			if (psmt != null)psmt.close();
			if (conn != null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<CartVO> selectCartList() {
		// TODO 장바구니 전체 조회
		sql = "select * from cart order by 1";

		List<CartVO> list = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {

				CartVO vo = new CartVO();
				vo.setItemCode(rs.getString("item_code"));
				vo.setItemQty(rs.getInt("item_qty"));
				vo.setUserID(rs.getString("user_id"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	@Override
	public CartVO selectCart(String id) {
		// TODO 장바구니 하나 조회

		sql = "select * from cart where user_id = ?";
		CartVO vo = new CartVO();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();

			if (rs.next()) {
				vo.setItemCode(rs.getString("item_code"));
				vo.setItemQty(rs.getInt("item_qty"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;
	}

	@Override
	public int insertCart(CartVO vo) {
		// TODO 장바구니 입력
		
		sql = "insert into cart values(?, ?, ?)";
		
		int result = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getUserID());
			psmt.setString(2, vo.getItemCode());
			psmt.setInt(3, vo.getItemQty());
			
			result = psmt.executeUpdate();
			
			if(result != 0) {
				System.out.println(result + "건 입력");
			} else {
				System.out.println("입력 ㄴㄴ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

	@Override
	public int updateCart(CartVO vo) {
		// TODO 장바구니 수정
		
		sql = "update cart set item_code = ?, item_qty = ? where user_id = ?";
		
		int result = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getItemCode());
			psmt.setInt(2, vo.getItemQty());
			psmt.setString(3, vo.getUserID());
			
			result = psmt.executeUpdate();
			
			if(result != 0) {
				System.out.println(result + "건 수정");
			} else {
				System.out.println("수정 ㄴㄴ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

	@Override
	public int deleteCart(CartVO vo) {
		// TODO 장바구니 삭제

		sql = "delete from cart where user_id = ?";
		
		int result = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getUserID());
			
			result = psmt.executeUpdate();
			
			if(result != 0) {
				System.out.println(result + "건 삭제");
			} else {
				System.out.println("삭제 ㄴㄴ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

}
