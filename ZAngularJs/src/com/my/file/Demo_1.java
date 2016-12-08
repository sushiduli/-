package com.my.file;

import java.io.File;

public class Demo_1 {

	public static void main(String[] args) throws Exception {
		
		String str = new String("\u6280\u5BA1\u65E5\u5FD7\u6587\u4EF6\u4E0D\u5B58\u5728".getBytes("UTF-8"));
		System.out.println("\u6280\u5BA1\u65E5\u5FD7\u6587\u4EF6\u4E0D\u5B58\u5728".getBytes("UTF-8"));
		System.out.println(str);
		File  dir = new File("G:\\Work2016\\1011");
		if(dir.isDirectory()){
			for (File file : dir.listFiles()) {
				if(!file.isDirectory()){
					//按名称排列 不需要时间参数了
					//System.out.println("文件名称——>"+file.getName()+"===修改时间——>"+file.lastModified());
					//System.out.println("文件路径："+file.getAbsolutePath());
				}
			}
		}
	}
}
