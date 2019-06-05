package com.cn.progressSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ������Ϣͨ���Ż�
 * @author Administrator
 * 2.1 ˫��ͨ�ţ�������Ϣ��������Ϣ
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
			InputStream inputStream = socket.getInputStream();
			byte[] bytes = new byte[1024];
		    int len;
		    StringBuilder sb = new StringBuilder();
		    //ֻ�е��ͻ��˹ر������������ʱ�򣬷���˲���ȡ�ý�β��-1
		    while ((len = inputStream.read(bytes)) != -1) {
		        // ע��ָ�������ʽ�����ͷ��ͽ��շ�һ��Ҫͳһ������ʹ��UTF-8
		        sb.append(new String(bytes, 0, len, "UTF-8"));
		      }
		    System.out.println("get message from client: " + sb);
		    OutputStream outputStream = socket.getOutputStream();
		    outputStream.write("Hello Client,I get the message.".getBytes("UTF-8"));
		    inputStream.close();
		    outputStream.close();
		    socket.close();
		    server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
       
	}
}
