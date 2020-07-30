package com.bn.serverinfo;



	import java.awt.List;
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.OutputStream;
	import java.net.InetAddress;
	import java.net.Socket;
	import java.sql.SQLException;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Date;

	import javax.swing.text.AbstractDocument.Content;

	public class ServerThread1 implements Runnable {
		// 定义当前线程所处理的Socket

		public String content = null;
	    
		
		Socket s = null;
		// 该线程所处理的Socket所对应的输入流
		BufferedReader br = null;

		public ServerThread1() {

		}

		public ServerThread1(Socket s) throws IOException {
			this.s = s;
			// 初始化该Socket对应的输入流
			br = new BufferedReader(new InputStreamReader(s.getInputStream(),"utf-8")); // ②
		}

		public void run() {
			// 采用循环不断从Socket中读取客户端发送过来的数据
			while ((content = readFromClient()) != null) {
				// 遍历socketList中的每个Socket，
				// 将读到的内容向每个Socket发送一次
				System.out.println(content);
				System.out.println("login success!");
			  DBUtil.getConnection();
			}

		}


		// 定义读取客户端数据的方法

		private String readFromClient()

		{

			try

			{

				return br.readLine();

			}

			// 如果捕捉到异常，表明该Socket对应的客户端已经关闭

			catch (IOException e)

			{

				// 删除该Socket。



			}

			return null;

		}




	}



