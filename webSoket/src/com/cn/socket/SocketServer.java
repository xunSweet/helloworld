package com.cn.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Socketͨ�Ż���ʾ��
 * @author Administrator
 *������ģʽ�ǻ������������գ����ڶ�Socket���Ż���������������ϵģ�Ҳ��Ϊ�Ժ�ѧϰNIO���̵档
 */
public class SocketServer {
	
	public static void main(String[] args) {
		// ����ָ���Ķ˿�
		int port = 55533;
	    try {
			ServerSocket server = new ServerSocket(port);
			// server��һֱ�ȴ����ӵĵ���
			System.out.println("server��һֱ�ȴ����ӵĵ���");
			Socket socket = server.accept();
			// ���������Ӻ󣬴�socket�л�ȡ�����������������������ж�ȡ
			InputStream  inputStream  =  (InputStream) socket.getInputStream();
			byte[] bytes = new byte[1024];
			int len;
			StringBuilder sb = new StringBuilder();
			while((len = inputStream.read(bytes))!=-1){
				//ע��ָ�������ʽ�����ͷ��ͽ��շ�һ��Ҫͳһ������ʹ��UTF-8
				sb.append(new String(bytes, 0, len,"UTF-8"));
			}
			System.out.println("get message from client :"+sb.toString());
			inputStream.close();
			socket.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
