package com.my.socket.senser;

import java.net.*;
import java.io.*;

public class Server1 {
	ServerSocket ss = null;
	Socket s = null;
	ObjectInputStream ois = null;

	// 构造方法
	public Server1() {
		try {
			ss = new ServerSocket(1234);
			s = ss.accept();
			System.out.println("在1234端口监听");
			// 以对象流方式读取(假定客户端发送的是User的一个对象)
			ois = new ObjectInputStream(s.getInputStream());
			User u = (User) ois.readObject();

			// 输出
			System.out.println("从客户端接收到了" + u.getName() + " " + u.getPass());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
				if (s != null) {
					s.close();
				}
				if (ss != null) {
					ss.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Server1 s1 = new Server1();
	}

}