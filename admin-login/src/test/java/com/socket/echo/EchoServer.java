package com.socket.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 *@author sunq
 *@date2020/11/3 16:15
 *@Description
 */
public class EchoServer {

	private final int port;

	public EchoServer(int port) {
		this.port = port;
	}


	public static void main(String[] args) throws InterruptedException {

		int port = 9999;
		EchoServer echoServer = new EchoServer(port);
		System.out.println("服务器即将启动...");
		echoServer.start();
		System.out.println("服务器即将关闭...");



	}

	public void start() throws InterruptedException {
		final EchoServerHandler handler = new EchoServerHandler();
		// 线程组
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			// 服务器端启动准备
			ServerBootstrap b = new ServerBootstrap();
			// 服务器端启动必须，指定使用nio的通信模式，
			b.group(group)		// 将线程组传入
					.channel(NioServerSocketChannel.class)		// 指定使用NIO进行网络传输
					.localAddress(new InetSocketAddress(port))		// 指定服务器监听端口监听端口
					// 服务端每接受到一个连接请求，就会启动一个socket通信，也就是channel，下面的代码作用就是为这个子channel增加handler
					.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel sc) throws Exception {
					// 将handler添加到子channel的pipeline的尾部
					sc.pipeline().addLast(handler);
				}
			});

			// 异步绑定到服务器，sync会阻塞到完成
			ChannelFuture future = b.bind().sync();
			// 阻塞当前线程，直到服务器的channel被关闭
			future.channel().closeFuture().sync();
		}finally {
			group.shutdownGracefully().sync();
		}
	}


}
