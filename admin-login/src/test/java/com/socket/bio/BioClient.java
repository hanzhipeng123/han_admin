package com.socket.bio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *@author sunq
 *@date2020/10/27 17:36
 *@Description
 */
public class BioClient {


	public static void main(String[] args){

		// 客户端创建socket
		Socket socket = null;
		ObjectInputStream is = null;
		ObjectOutputStream os = null;
		InetSocketAddress addr = new InetSocketAddress("127.0.0.1", 10002);

		try {
			socket = new Socket();
			socket.connect(addr);
			System.out.println("connect to server success.");
			os = new ObjectOutputStream(socket.getOutputStream());
			is = new ObjectInputStream(socket.getInputStream());

			// 发送给服务端
			os.writeUTF("sunq \n");
			os.flush();
			System.out.println("send to server success.");
			// 接受服务端
			String serverMessage = is.readUTF();
			System.out.println("accept server message：" + serverMessage);

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			if (is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (os != null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}


	}



}
