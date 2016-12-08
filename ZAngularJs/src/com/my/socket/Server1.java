package com.my.socket;

import java.io.IOException;
import java.net.*;
import java.util.Date;
import java.io.*;

public class Server1 {
	ServerSocket ss = null;
	Socket s = null;

	// 构造方法
	public Server1()   {
		try {
			// 在9999端口进行监听
			ss = new ServerSocket(9999);
			// 等待某个客户端来连接，该方法会返回一个Socket连接
			s = ss.accept();

			// 读取s中传递的数据
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			String info = br.readLine();
			System.out.println(new Date().getTime()+"服务器接收到了" + info);

			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			pw.println("Hello,Client!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (s != null) {
					s.close();
				}
				if (ss != null) {
					ss.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Server1 s1 = new Server1();
	}

}