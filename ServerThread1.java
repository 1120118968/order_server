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
		// ���嵱ǰ�߳��������Socket

		public String content = null;
	    
		
		Socket s = null;
		// ���߳��������Socket����Ӧ��������
		BufferedReader br = null;

		public ServerThread1() {

		}

		public ServerThread1(Socket s) throws IOException {
			this.s = s;
			// ��ʼ����Socket��Ӧ��������
			br = new BufferedReader(new InputStreamReader(s.getInputStream(),"utf-8")); // ��
		}

		public void run() {
			// ����ѭ�����ϴ�Socket�ж�ȡ�ͻ��˷��͹���������
			while ((content = readFromClient()) != null) {
				// ����socketList�е�ÿ��Socket��
				// ��������������ÿ��Socket����һ��
				System.out.println(content);
				System.out.println("login success!");
			  DBUtil.getConnection();
			}

		}


		// �����ȡ�ͻ������ݵķ���

		private String readFromClient()

		{

			try

			{

				return br.readLine();

			}

			// �����׽���쳣��������Socket��Ӧ�Ŀͻ����Ѿ��ر�

			catch (IOException e)

			{

				// ɾ����Socket��



			}

			return null;

		}




	}



