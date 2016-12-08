package com.my.jxl;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Orientation;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class TestExport {

	public static void main(String[] args) throws IOException, WriteException {
		
		
		
		String[] tilte = new String[]{"序号","资产名称","资产类型","创建时间","删除人","删除时间","删除主机"};
		
		File file = new File("D://test.xls");
		WritableWorkbook workbook = Workbook.createWorkbook(file);
		WritableSheet sheet = workbook.createSheet("资产信息", 0);
		Label label = new Label(2, 0, "测试导出Excel文件信息",getHeader());
		sheet.addCell(label);

		for (int i = 0; i < tilte.length; i++) {
			label = new Label(i, 1, tilte[i]);
			sheet.addCell(label);
		}

		for (int i = 0; i < 10; i++) {
			label = new Label(0, i+2, i+"");
			sheet.addCell(label);
			for (int j = 1; j < tilte.length; j++) {
				label = new Label(j, i+2, i+""+j);
				sheet.addCell(label);
			}
			
		}
		workbook.write();
		workbook.close();
		System.out.println("创建完成");
	}
	
 
	public static WritableCellFormat getHeader(){
		
		WritableFont font = new WritableFont(WritableFont.TIMES,15,WritableFont.BOLD);
		
		WritableCellFormat  format  = new WritableCellFormat(font);
		try {
			format.setAlignment(Alignment.CENTRE);
			format.setOrientation(Orientation.HORIZONTAL);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return format;
	}
}
