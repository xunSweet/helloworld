package com.cn.progressSocketter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ������Ϣͨ���Ż�
 * @author Administrator
 * 2.3.4 ͨ��ָ������
 * ������˽�һ��class�ļ��Ľṹ��������д�������ڴ�������ô��ͻ������ô��Ʒ�ʽ��
 * Ҳ����˵���ǿ����ڴ�����У��������ǿ�����ָ����������ĳ��ȣ�Ȼ���ȡָ�����ȵ�������Ϊ�ͻ��˷��͵���Ϣ��
 * 
 * 
 * 
 * ������Ҫ����������ü����ֽ�ָ�������أ����ǿ�����һ�㣺
 * 1���ֽڣ����256����ʾ256B
   2���ֽڣ����65536����ʾ64K
   3���ֽڣ����16777216����ʾ16M
   4���ֽڣ����4294967296����ʾ4G
         ��������
   ��  ���ʱ���ǲ��Ǻܾ��ᣬ���ĵ�Ȼ����յģ���������б�Ҫѡ����������ʵ�������΢�˽�һ��UTF-8�ı��뷽ʽ
       ���ַ����������д�������ڴ�������ô���Ӧ�����뵽Ϊʲôһ��Ҫ�̶���ʾ�����ֽڵĳ����أ����ǿ���ʹ�ñ䳤��ʽ����ʾ���ȵı�ʾ�����磺    
        ��һ���ֽ���λΪ0����0XXXXXXX����ʾ���Ⱦ�һ���ֽڣ����128����ʾ128B
        ��һ���ֽ���λΪ110����ô��������һ���ֽڱ�ʾ���ȣ���110XXXXX 10XXXXXX�����2048����ʾ2K
        ��һ���ֽ���λΪ1110����ô������������ֽڱ�ʾ���ȣ���110XXXXX 10XXXXXX 10XXXXXX�����131072����ʾ128K
        ��������
        �����ᵽ�������÷��ʺϸ߸�˧�ĳ���Աʹ�ã�һ���أ���������������ͣ������ֽھ͹��ˣ������������4���ֽڻ������������������Ҫ��
        ������������ǽ�����2���ֽڱ�ʾ���ȣ�Ŀ��ֻ�Ǹ���һ��˼·������֪�������ַ�ʽ����ȡ��Ϣ�Ľ�β��
 */
public class SocketServer {
   public static void main(String[] args) {
	 //����ָ���Ķ˿�
	   int port  =55533;
	   try {
		ServerSocket server   = new ServerSocket(port);
		//server��һֱ�ȴ����ӵĵ���
		System.out.println("server��һֱ�ȴ����ӵĵ���");
		Socket socket = server.accept();
		// ���������Ӻ󣬴�socket�л�ȡ�����������������������ж�ȡ
		InputStream inputStream = socket.getInputStream();
		byte[] bytes;
		// ��Ϊ���Ը���Socket�����жϳ��ȣ����Կ���һ��Socket�õ���
		while(true){
			// ���ȶ�ȡ�����ֽڱ�ʾ�ĳ���
			int first = inputStream.read();
			//�����ȡ��ֵΪ-1 ˵����������ĩβ��Socket�Ѿ����ر��ˣ���ʱ��������ȥ��ȡ
			if(first==-1){
		        break;
		      }
			int second = inputStream.read();
			int length = (first << 8) + second;
			// Ȼ����һ��ָ������byte����
			bytes = new byte[length];
			// Ȼ���ȡָ�����ȵ���Ϣ����
			inputStream.read(bytes);
			System.out.println("get message from client: " + new String(bytes, "UTF-8"));
		}
		inputStream.close();
		socket.close();
		server.close();
	} catch (IOException e) {
		e.printStackTrace();
	}	   	   	
}
}
