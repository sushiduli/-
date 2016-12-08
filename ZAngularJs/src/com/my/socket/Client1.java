package com.my.socket;
import java.io.IOException;
import java.net.*;
import java.util.Date;
import java.io.*;
public class Client1 {
	Socket s = null;
	//构造方法
	public Client1(){
		try {
			//Socket()方法可以连接某个服务器，127.0.0.1表示服务器的IP，9999是该服务器的端口号
			s = new Socket("127.0.0.1", 9999);
			//连接成功，就可以发送数据给服务器
			//通过PrintWriter向s写数据，true表示即时刷新
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			pw.println("Hello,Server!");
			
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			String resp = br.readLine();
			System.out.println(new Date().getTime()+"客户端接收到了" + resp);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(s != null){
					s.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Client1 c1 = new Client1();
	}

}