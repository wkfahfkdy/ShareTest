package com.shop.product.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.common.DAO;
import com.shop.product.service.ProductService;
import com.shop.product.vo.ProductVO;

public class ProductServiceImpl extends DAO implements ProductService {

	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public void close() {
		
		try {
			if (rs != null) rs.close();
			if (psmt != null) psmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ProductVO getDiviCookie() {
		
		sql = "select division from product where division='쿠키'";
		ProductVO vo = new ProductVO();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setDivision(rs.getString("division"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}
	
	public ProductVO getDiviBread() {
		
		sql = "select division from product where division='빵'";
		ProductVO vo = new ProductVO();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setDivision(rs.getString("division"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}
	
	public ProductVO getDiviHMR() {
		
		sql = "select division from product where division='간편식'";
		ProductVO vo = new ProductVO();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setDivision(rs.getString("division"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}
	
	public ProductVO getDiviDrink() {
		
		sql = "select division from product where division='음료'";
		ProductVO vo = new ProductVO();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setDivision(rs.getString("division"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}
	
	public ProductVO goDesc(String itemCode) {
		
		sql = "select * from product where item_code = ?";
		ProductVO vo = new ProductVO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, itemCode);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setDivision(rs.getString("division"));
				vo.setItemCode(rs.getString("item_code"));
				vo.setItemDesc(rs.getString("item_desc"));
				vo.setItemImage(rs.getString("item_image"));
				vo.setItemName(rs.getString("item_name"));
				vo.setLikeIt(rs.getInt("like_it"));
				vo.setPrice(rs.getInt("price"));
				vo.setSale(rs.getString("sale"));
				vo.setSalePrice(rs.getInt("sale_price"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}
	
	@Override
	public List<ProductVO> selectCategory(ProductVO vo) {
		// 카테고리 별 조회
		
		sql = "select * from product where division = ? order by 1 desc";
		List<ProductVO> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getDivision());
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				vo.setItemCode(rs.getString("item_code"));
				vo.setItemDesc(rs.getString("item_desc"));
				vo.setItemImage(rs.getString("item_image"));
				vo.setItemName(rs.getString("item_name"));
				vo.setLikeIt(rs.getInt("like_it"));
				vo.setPrice(rs.getInt("price"));
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
	
	@Override
	public List<ProductVO> selectProductList() {
		// 상품 전체 조회
		
		sql = "select * from product order by 1";
		List<ProductVO> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
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

	@Override
	public int insertProduct(ProductVO vo) {
		// 상품 입력
		
		int result = 0;
		sql = "insert into product values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getItemCode());
			psmt.setString(2, vo.getItemName());
			psmt.setString(3, vo.getItemImage());
			psmt.setInt(4, vo.getPrice());
			psmt.setString(5, vo.getItemDesc());
			psmt.setInt(6, vo.getLikeIt());
			psmt.setString(7, vo.getSale());
			psmt.setInt(8, vo.getSalePrice());
			psmt.setString(9, vo.getDivision());
			
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
	public int updateProduct(ProductVO vo) {
		// 상품 정보 수정
		
		int result = 0;
		sql = "update product set "
				+ "item_name = ?, item_image = ?, price = ?, like_it = ?, "
				+ "sale = ?, sale_price = ?, division = ?"
				+ "where item_code = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getItemName());
			psmt.setString(2, vo.getItemImage());
			psmt.setInt(3, vo.getPrice());
			psmt.setString(4, vo.getItemDesc());
			psmt.setInt(5, vo.getLikeIt());
			psmt.setString(6, vo.getSale());
			psmt.setInt(7, vo.getSalePrice());
			psmt.setString(8, vo.getDivision());
			psmt.setString(9, vo.getItemCode());
			
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
	public int deleteProduct(ProductVO vo) {
		// 상품 삭제
		
		int result = 0;
		sql = "delete from product where item_code = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getItemCode());
			
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
