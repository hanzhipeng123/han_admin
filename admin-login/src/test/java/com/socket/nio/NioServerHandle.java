package com.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 *@author sunq
 *@date2020/10/29 15:55
 *@Description
 */
public class NioServerHandle implements Runnable{

	private volatile boolean started;
	private ServerSocketChannel serverSocketChannel;
	private Selector selector;

	// 构造方法，指定要监听的端口号
	public NioServerHandle(int port) {

		try{
			// 创建选择器实例
			selector = Selector.open();
			// 创建 serverSocketChannel 实例
			serverSocketChannel = ServerSocketChannel.open();
			// 设置通道为非阻塞模式
			serverSocketChannel.configureBlocking(false);
			// 绑定端口
			serverSocketChannel.socket().bind(new InetSocketAddress(port));
			// 向 selector 注册，表示关心客户端连接事件
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


			started = true;
			System.out.println("服务器已启动，端口号：" + port);



		}catch (IOException e){
			e.printStackTrace();
		}

	}

	@Override
	public void run() {

		// 不断的从选择器上选择等客户端的连接事件
		while (started){
			// 阻塞式的获取连接事件
			// select(long timeout)  超时的阻塞
			// selectNow() 不阻塞获取
			try {
				selector.select();
				// 获取选择器的事件集合
				Set<SelectionKey> eventKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = eventKeys.iterator();
				while (iterator.hasNext()){
					// 获取事件集合
					SelectionKey event = iterator.next();
					// 从事件集中移除，防止重复处理
					iterator.remove();
					// 处理事件
					handleEvent(event);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}


		}


	}



	private void handleEvent(SelectionKey key) throws IOException {
		// 判断事件是否有效
		if (key.isValid()){
			// 连接事件，客户端的连接请求
			if (key.isAcceptable()){
				// 处理新接入的链接，产生一个 socket
				ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
				// 接受链接
				SocketChannel sc = ssc.accept();
				System.out.println("=====建立连接=====");
				// socket 设置为非阻塞模式
				sc.configureBlocking(false);
				// socket 注册到 selector 上，关注读事件
				sc.register(selector, SelectionKey.OP_READ);
			}

			// 读事件，处理对端发送的数据
			if (key.isReadable()){
				// 处理读事件，获取 channel
				SocketChannel sc = (SocketChannel)key.channel();
				// 新建一个buffer
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				// 从通道里读取到的数据，写 到buffer中
				int readBytes = sc.read(buffer);
				// 从通道（channel）中读取到了数据，给应用程序
				if (readBytes > 0){
					// 数据从通道（channel）到 buffer是写操作（把通道的数据 写 到 buffer中），接着要从buffer 读取数据写给应用程序，需要转换模式
					buffer.flip();
					// 定义一个数组，存 buffer 中的数据
					byte[] data = new byte[buffer.remaining()];
					buffer.get(data);
					String message = new String(data, "UTF-8");
					System.out.println("服务器接收到消息：" + message);
					// 返回的数据
					String res = Const.response(message);
					doWrite(res, sc);

				}
			}
		}
	}

	// 用buffer往channel里写数据
	private void doWrite(String res, SocketChannel sc) throws IOException {

		byte[] bytes = res.getBytes();
		// 开辟一个buffer，大小为需要返回的数据大小
		ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		// 发送的数据 写 到buffer中
		buffer.put(bytes);
		// 转换模式，接下来要从buffer中 读 数据，写到通道中去
		buffer.flip();
		// 写到通道中
		sc.write(buffer);

	}


}
