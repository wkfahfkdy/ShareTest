package com.shop.cart.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.cart.service.CartService;
import com.shop.cart.vo.CartVO;
import com.shop.common.DAO;
import com.shop.product.vo.ProductVO;

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
	
	// 장바구니 금액 총합계
	public int fsum(String id) {
		
		int fsum = 0;
		
		sql = "SELECT sum(A.SALE_PRICE * B.qtySum) AS fsum\r\n"
				+ "FROM PRODUCT A\r\n"
				+ ", (\r\n"
				+ "  select user_id, item_code, sum(item_qty) AS qtySum\r\n"
				+ "  from cart \r\n"
				+ "  group by user_id, item_code \r\n"
				+ "  having user_id=?) B\r\n"
				+ "WHERE A.ITEM_CODE = B.ITEM_CODE";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				fsum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return fsum;
	}
	
	// 장바구니 리스트
	public List<ProductVO> cartList(String id) {
		
		sql = "SELECT A.*, B.USER_ID, B.qtySum, A.SALE_PRICE * B.qtySum AS priceSum\r\n"
				+ "FROM PRODUCT A\r\n"
				+ ", (\r\n"
				+ "  select user_id, item_code, sum(item_qty) AS qtySum\r\n"
				+ "  from cart \r\n"
				+ "  group by user_id, item_code \r\n"
				+ "  having user_id=?) B\r\n"
				+ "WHERE A.ITEM_CODE = B.ITEM_CODE\r\n"
				+ "order by A.item_code";
		
		List<ProductVO> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				
				vo.setDivision(rs.getString("division"));
				vo.setItemCode(rs.getString("item_code"));
				vo.setItemDesc(rs.getString("item_desc"));
				vo.setItemImage(rs.getString("item_image"));
				vo.setItemName(rs.getString("item_name"));
				vo.setLikeIt(rs.getInt("like_it"));
				vo.setPrice(rs.getInt("price"));
				vo.setPriceSum(rs.getInt("priceSum"));
				vo.setQtySum(rs.getInt("qtySum"));
				vo.setSale(rs.getString("sale"));
				vo.setSalePrice(rs.getInt("sale_price"));
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	public int getCnt(String id) {
		
		sql = "select count(*) from cart where user_id = ?";
		int cnt = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return cnt;
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
		
		sql = "insert into cart values(?, ?, 1)";
		
		int result = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getUserID());
			psmt.setString(2, vo.getItemCode());
			
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
