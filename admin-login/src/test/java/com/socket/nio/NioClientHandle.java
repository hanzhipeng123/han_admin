package com.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 *@author sunq
 *@date2020/10/29 16:02
 *@Description
 */
public class NioClientHandle implements Runnable{

	private String host;
	private int port;
	private volatile boolean started;
	private SocketChannel socketChannel;
	private Selector selector;

	public NioClientHandle(String host, int port) {
		this.host = host;
		this.port = port;

		try {
			// 创建选择器
			selector = Selector.open();
			// 打开一个socket
			socketChannel = SocketChannel.open();
			// 设置非阻塞
			socketChannel.configureBlocking(false);

			started = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 停止客户端
	public void stop(){
		started = false;
	}


	@Override
	public void run() {

		// 建立连接
		try {
			doConnect();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 客户端开启
		while (started){
			try {
				// 无论是否有事件发生，每隔 1s 唤醒一次 selector
				selector.select(1000);
				// 获取当前发生的事件
				Set<SelectionKey> keys = selector.selectedKeys();
				// 转成迭代器
				Iterator<SelectionKey> iterator = keys.iterator();
				SelectionKey key = null;
				while (iterator.hasNext()){
					key = iterator.next();
					iterator.remove();
					handleInput(key);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}


		}

	}

	// 处理事件
	private void handleInput(SelectionKey key) throws IOException {

		if (key.isValid()){

			SocketChannel channel = (SocketChannel)key.channel();
			// 连接事件
			if (key.isConnectable()){
				if (socketChannel.finishConnect()){
					socketChannel.register(selector, SelectionKey.OP_READ);
				}else
					System.exit(1);
			}
			// 读事件
			if (key.isReadable()){
				// 创建buffer，开辟 1024大小的缓冲区
				ByteBuffer buffer = ByteBuffer.allocate(1024);
				// 读取请求的数据，把channel的数据 写到 buffer中
				int read = socketChannel.read(buffer);
				if (read > 0){
					// 转换为读模式，读缓冲区的数据，写到数组里给应用程序使用
					buffer.flip();
					byte[] bytes = new byte[buffer.remaining()];
					// 从缓存中读数据
					buffer.get(bytes);
					String res = new String(bytes, "UTF-8");
					System.out.println("客户端收到消息：" + res);
				}else if (read < 0){
					// channel已经关闭，释放资源
					key.cancel();
				}
			}
		}
	}

	// 建立连接
	private void doConnect() throws IOException {

		// 连接服务器
		if (socketChannel.connect(new InetSocketAddress(host, port))){
			// 建立连接成功，注册读事件
			// 绑定连接事件
			socketChannel.register(selector, SelectionKey.OP_READ);
		}else {
			// 建立连接失败，注册连接事件
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
		}

	}

	// 写到服务器
	private void doWrite(SocketChannel socketChannel, String msg) throws IOException {
		byte[] bytes = msg.getBytes();
		// 开辟一个buffer，大小为需要返回的数据大小
		ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		// 发送的数据 写 到buffer中
		buffer.put(bytes);
		// 转换模式，接下来要从buffer中 读 数据，写到通道中去
		buffer.flip();
		// 写到通道中
		socketChannel.write(buffer);
	}


	// 发送消息
	public void sendMessage(String msg) throws IOException {
		doWrite(socketChannel, msg);
	}


}
