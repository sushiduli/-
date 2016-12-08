/**
 * 半双工
 * 服务器端,9999端口监听
 * 可以接收从客户端发来的信息
 */
package com.my.socket;

import java.net.*;
import java.io.*;

public class Server2 {
	ServerSocket ss = null;
	Socket s = null;
	BufferedReader br1 = null;
	BufferedReader br2 = null;
	PrintWriter pw = null;

	// 构造方法
	public Server2() {
		try {
			// 在9999端口进行监听
			ss = new ServerSocket(9999);
			// 等待某个客户端连接，返回 Socket
			s = ss.accept();

			while (true) {
				// 从客户端接收消息
				br1 = new BufferedReader(new InputStreamReader(
						s.getInputStream()));
				String str = br1.readLine();
				System.out.println("从客户端收到的消息是：" + str);
				// 如果收到消息为"byebye",关闭服务器
				if (str.equals("byebye")) {
					System.out.println("服务器关闭连接");
					break;
				}

				// 从控制台输入
				System.out.print("从控制台输入：");
				br2 = new BufferedReader(new InputStreamReader(System.in));
				// 将消息发送给客户端
				pw = new PrintWriter(s.getOutputStream(), true);
				pw.println(br2.readLine());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭资源
				if (pw != null) {
					pw.close();
				}
				if (br2 != null) {
					br2.close();
				}
				if (br1 != null) {
					br1.close();
				}
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
		Server2 s2 = new Server2();
	}
}