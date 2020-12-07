package com.socket.bio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *@author sunq
 *@date2020/10/27 17:25
 *@Description
 */
public class BioServer {

	public static void main(String[] args) throws IOException {

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		ServerSocket serverSocket = new ServerSocket();
		// 绑定本机，指定ip
		serverSocket.bind(new InetSocketAddress(10002));
		System.out.println("Server is start....");
		while (true){
			executorService.execute(new ServerTask(serverSocket.accept()));
		}

	}

	private static class ServerTask implements Runnable{

		private Socket socket = null;

		public ServerTask(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {

			try(
				// 获取输入输出流
				ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream())){;

				// 获取客户端输入
				String userName = is.readUTF();
				System.out.println("accept client message：" + userName);

				// 返回给客户端
				os.writeUTF("hello，" + userName);
				os.flush();
			}catch (Exception e){
				e.printStackTrace();
			}finally {
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


}
