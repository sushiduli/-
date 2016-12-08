package com.my.socket.senser;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {
	Socket s = null;
	ObjectOutputStream oos = null;

	// 构造方法
	public Client1() {
		try {
			s = new Socket("127.0.0.1", 1234);
			// 通过ObjectOutputStream给服务器传递对象
			oos = new ObjectOutputStream(s.getOutputStream());
			User u = new User();
			u.setName("张三");
			u.setPass("123456");
			oos.writeObject(u);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (s != null) {
					s.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Client1 c1 = new Client1();
	}
}