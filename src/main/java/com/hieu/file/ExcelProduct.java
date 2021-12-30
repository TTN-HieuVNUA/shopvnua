package com.hieu.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hieu.bean.ProductDetail;
import com.hieu.service.inter.ProductDetailSv;

@Controller
public class ExcelProduct {

	@Autowired
	private ProductDetailSv productDetailSv;
	
	@PostMapping(value = "/exportproduct")
	public ModelAndView exportFileProduct() throws IOException {
		ModelAndView modelAndView = new ModelAndView("redirect: admin/listproduct");
		List<ProductDetail> proList = new ArrayList<ProductDetail>();
		proList = productDetailSv.getListProductDetail();
		String time = new Timestamp(System.currentTimeMillis()).toString();
		time = time.replace(":", "-");
		String path = "K://java//shopvnua//src//main//resources//productlist"+time+".xlsx";
		FileOutputStream file = new FileOutputStream(path);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("listproduct");
		
		HSSFRow row;
		HSSFCell id;
		HSSFCell name;
		HSSFCell trademark;
		HSSFCell color;
		HSSFCell price;
		HSSFCell size;
		HSSFCell quantity;
		HSSFCell createddate;
		HSSFCell createdby;
		
		row = sheet.createRow(0);
		id = row.createCell(0);
		name = row.createCell(1);
		trademark = row.createCell(2);
		color = row.createCell(3);
		price = row.createCell(4);
		size = row.createCell(5);
		quantity = row.createCell(6);
		createddate = row.createCell(7);
		createdby = row.createCell(8);
		
		id.setCellValue("số thứ tự");
		name.setCellValue("tên sản phẩm");
		trademark.setCellValue("thương hiệu");
		color.setCellValue("màu sắc");
		price.setCellValue("giá nhập");
		size.setCellValue("size");
		quantity.setCellValue("số lượng");
		createddate.setCellValue("ngày nhập");
		createdby.setCellValue("người nhập");
		
		for(int i=0; i<proList.size(); i++) {
			int z= i;
			int index = i;
			row = sheet.createRow(z+1);
			id = row.createCell(0);
			name = row.createCell(1);
			trademark = row.createCell(2);
			color = row.createCell(3);
			price = row.createCell(4);
			size = row.createCell(5);
			quantity = row.createCell(6);
			createddate = row.createCell(7);
			createdby = row.createCell(8);
			id.setCellValue(++index);
			name.setCellValue(proList.get(i).getProductid().getName());
			trademark.setCellValue(proList.get(i).getProductid().getTrademarkid().getName());
			color.setCellValue(proList.get(i).getColor());
			price.setCellValue(proList.get(i).getPrice().toPlainString());
			size.setCellValue(proList.get(i).getSize());
			quantity.setCellValue(proList.get(i).getQuantity());
			createddate.setCellValue(proList.get(i).getCreatedDate());
			createdby.setCellValue(proList.get(i).getCreatedBy().getName());
		}
		
		workbook.write(file);
		workbook.close();
		file.close();
		return modelAndView;
	}
	
}
