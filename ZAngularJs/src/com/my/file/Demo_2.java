/*package com.my.file;

import java.io.File;
import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class Demo_2 {

	 *//**
	  * @param args
	  * @throws IOException
	  *//*
	 public static void main(String[] args) throws IOException {
	  getPdfFileText("G:\\Work2016\\1019");
	 }

	 public static void getPdfFileText(String fileName) {
		 
		 
			 File dir = new File(fileName);
			 if(dir.isDirectory()){
				
				for (File pdffile :  dir.listFiles()) {
					String pdfname = pdffile.getName();
					if(pdfname.endsWith(".pdf")){
						  try {
							  //System.out.println(pdffile.getAbsolutePath());
							  PdfReader reader = new PdfReader(pdffile.getAbsolutePath());
							  PdfReaderContentParser parser = new PdfReaderContentParser(reader);
							  StringBuffer buff = new StringBuffer();
							  TextExtractionStrategy strategy;
							  for (int i = 1; i <= reader.getNumberOfPages(); i++) {
							   strategy = parser.processContent(i,
							     new SimpleTextExtractionStrategy());
							   buff.append(strategy.getResultantText());
							   if(buff.toString().contains("22213")){
									  System.out.println("文件："+pdfname+"=====检测到错误信息22213=================================");
							   }
							  }
							  if(!buff.toString().contains("22213")){
								  System.out.println("文件："+pdfname+"==未检测到错误信息22213=================================");
						   }
						  } catch (Throwable e) {
							System.out.println(e.getMessage());
						  }
					  }
				}
			 }
	 }
}
*/