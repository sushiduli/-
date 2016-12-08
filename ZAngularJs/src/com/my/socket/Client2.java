package com.my.socket;

import java.net.*;
import java.io.*;

public class Client2 {
	Socket s = null;
	PrintWriter pw = null;
	BufferedReader br1 = null;
	BufferedReader br2 = null;

	public Client2() {
		try {
			// Socket()方法可以连接某个服务器，127.0.0.1表示服务器的IP，9999是该服务器的端口号
			s = new Socket("127.0.0.1", 9999);
			while (true) {
				// 连接成功，就可以发送数据给服务器
				// 从控制台读入数据
				System.out.print("从控制台输入：");
				br1 = new BufferedReader(new InputStreamReader(System.in));
				String str = br1.readLine();
				// 通过PrintWriter向s写数据，true表示即时刷新
				pw = new PrintWriter(s.getOutputStream(), true);
				pw.println(str);
				if (str.equals("byebye")) {
					System.out.println("客户端关闭连接");
					break;
				}

				// 从服务端接收消息
				br2 = new BufferedReader(new InputStreamReader(
						s.getInputStream()));
				System.out.println("从服务器接收的消息是：" + br2.readLine());
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Client2 c2 = new Client2();
	}

}