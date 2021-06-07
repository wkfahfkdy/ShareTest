package com.shop.product.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shop.common.DbCommand;
import com.shop.product.service.ProductService;
import com.shop.product.serviceImpl.ProductServiceImpl;
import com.shop.product.vo.ProductVO;

public class FileUploadUpdate implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("upload");				// 
		//String path = "D:\\ShareTest\\TestShop\\WebContent\\upload";
		//System.out.println("경로 : " + path);
		
		try {
			MultipartRequest multi = new MultipartRequest(request, path , 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			
			Enumeration en = multi.getFileNames();	// 여기서 itemImage 가져오는 것
			
			String itemCode = multi.getParameter("itemCode");
			String itemName = multi.getParameter("itemName");
			// String itemImage = multi.getParameter("itemImage"); // 안쓰는거 보니까 애초에 안적어도 될듯???
			// 나중에 만들때 이미지 등록한건 name = "" 따로 안따도 될거같음. 어자피 여기서 안쓰고 알아서 불러오는 것같음
			String likeIt = multi.getParameter("likeIt");
			String price = multi.getParameter("price");
			String itemDesc = multi.getParameter("itemDesc");
			String sale = multi.getParameter("sale");
			String salePrice = multi.getParameter("salePrice");
			String division = multi.getParameter("division");
			
			String fineN = null;
			
			while(en.hasMoreElements()) { // file 여러개 입력 시 - 어떻게 되게? 중복방지? 
				String name = (String) en.nextElement();
				String fileName = multi.getFilesystemName(name);
				fineN = fileName;
			}
			
			ProductService service = new ProductServiceImpl();
			ProductVO vo = new ProductVO();
			
			vo.setDivision(division);
			vo.setItemCode(itemCode);
			vo.setItemDesc(itemDesc);
			vo.setItemImage(fineN);
			vo.setItemName(itemName);
			vo.setLikeIt(Integer.parseInt(likeIt));
			vo.setPrice(Integer.parseInt(price));
			vo.setSale(sale);
			vo.setSalePrice(Integer.parseInt(salePrice));
			
			service.updateProduct(vo);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "productManageUD.do";
	}

}
