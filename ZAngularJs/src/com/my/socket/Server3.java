package com.my.socket;

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.RenderingHints.Key;

import javax.swing.*;
import java.awt.event.*;

public class Server3 extends JFrame implements ActionListener, KeyListener {

	// 网络变量
	ServerSocket ss = null;
	Socket s = null;

	// IO流
	BufferedReader br = null;
	PrintWriter pw = null;

	// 定义组件
	JTextArea jta = null;
	JTextField jtf = null;
	JButton jb = null;
	JPanel jp1 = null;
	JScrollPane jsp = null;

	// 构造方法
	public Server3() {
		// 创建组件
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		jtf = new JTextField(20);
		jtf.addKeyListener(this);
		jb = new JButton("发送");
		jb.addActionListener(this);
		jp1 = new JPanel();

		// 添加到JPanel
		jp1.add(jtf);
		jp1.add(jb);

		// 添加到JFrame
		add(jsp, "Center");
		add(jp1, "South");

		// 设置窗体
		setTitle("服务器端");
		setSize(400, 300);
		setLocation(0, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		try {
			// 服务器监听
			ss = new ServerSocket(6166);
			// 等待客户端连接
			s = ss.accept();

			// 创建读入缓冲字符流
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			// 创建打印流
			pw = new PrintWriter(s.getOutputStream(), true);

			while (true) {
				// 读取从客户端发来的信息
				// 当没有消息过来时，会一直处于阻塞状态，这条语句也就不会执行
				String info = br.readLine();
				jta.append("客户端：" + info + "\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server3 s3 = new Server3();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jb) {
			// 点击确定，发送信息
			// 把服务器在jtf写的内容发送给客户端，并在jta显示
			String info = jtf.getText();
			pw.println(info);
			jta.append("服务器：" + info + "\r\n");
			jtf.setText("");
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			// 按下Enter，发送信息
			// 把服务器在jtf写的内容发送给客户端，并在jta显示
			String info = jtf.getText();
			pw.println(info);
			jta.append("服务器：" + info + "\r\n");
			jtf.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}