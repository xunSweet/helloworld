package com.cn.progressSocketter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/***
 * �˴��Ķ�ȡ����Ϊ���ȶ�ȡ�����ֽڵĳ��ȣ�Ȼ���ȡ��Ϣ���ͻ���Ϊ��
 * @author Administrator
 *
 */
public class SocketClient {
   public static void main(String[] args) {
	   // Ҫ���ӵķ����IP��ַ�Ͷ˿�
	    String host = "127.0.0.1";
	    int port = 55533;
	    // �����˽�������
	    try {
			Socket socket = new Socket(host, port);
			// �������Ӻ��������
		    OutputStream outputStream = socket.getOutputStream();
		    String message = "���  yiwangzhibujian";
		    //������Ҫ�����֪��Ϣ�ĳ���
		    byte[] sendBytes = message.getBytes("UTF-8");
		     //Ȼ����Ϣ�ĳ������ȷ��ͳ�ȥ
		    outputStream.write(sendBytes.length >>8);
		    outputStream.write(sendBytes.length);
		    //Ȼ����Ϣ�ٴη��ͳ�ȥ
		    outputStream.write(sendBytes);
		    outputStream.flush();
		    //==========�˴��ظ�����һ�Σ�ʵ����Ŀ��Ϊ����������˴�ֻΪչʾ�÷�
		    message = "�ڶ�����Ϣ";
		    sendBytes = message.getBytes("UTF-8");
		    outputStream.write(sendBytes.length >>8);
		    outputStream.write(sendBytes.length);
		    outputStream.write(sendBytes);
		    outputStream.flush();
		    //==========�˴��ظ�����һ�Σ�ʵ����Ŀ��Ϊ����������˴�ֻΪչʾ�÷�
		    message = "the third message!";
		    sendBytes = message.getBytes("UTF-8");
		    outputStream.write(sendBytes.length >>8);
		    outputStream.write(sendBytes.length);
		    outputStream.write(sendBytes);    
		    outputStream.close();
		    socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
  }
}
