package com.bn.serverinfo;//���������

import java.net.ServerSocket;
import java.net.Socket;

import static  com.bn.serverinfo.Constant.*;
public class ServerThread extends Thread{              //����һ����ServerThread�ļ̳��̵߳���
	     public ServerSocket ss;                        //����һ��ServerSocket����
	     @Override
	     public void run(){                            //��дrun����
	     	try{                                        //���õ����磬��Ҫ�����쳣����
	     		ss=new ServerSocket(9999);                //����һ���󶨵��˿�9999�ϵ�ServerSocket����
	     		System.out.println("Socket success :9999");//��ӡ��ʾ��Ϣ��Socket���󴴽��ɹ�9999
	     	}
	     	catch(Exception e){                           //�����쳣	     	
	     		e.printStackTrace();
	     	}
	 		while(flag){                          //����Whileѭ��	 		
	 			try{	 			
	 				Socket sc=ss.accept();//���ܿͻ��˵��������������������󷵻����Ӷ�Ӧ��Socket����
	 				System.out.println("�ͻ������󵽴"+sc.getInetAddress());//��ӡ��ʾ��Ϣ sc.getInetAddress()
	 			
	// 		         new Thread(new ServerThread1(sc)).start();
	 				ServerAgentThread sat=new ServerAgentThread(sc); 	//����һ����������߳�	
 		
	 				sat.start();	//������������߳�
	 	           //Socket s = ss.accept();
	 	           //socketList.add(sc);
	 	           // ÿ���ͻ������Ӻ�����һ��ServerThread�߳�Ϊ�ÿͻ��˷���
	 	  
	 			}
	 			catch(Exception e){		     	
		     		e.printStackTrace();
		     	} 			
	 		}
	     }	
	     public static void main(String args[]){            //��д������
	    	 (new ServerThread()).start();               //����һ�������̲߳�����
	     }
	}