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
			// 指定使用nio的通信模式，
			b.group(group).channel(NioServerSocketChannel.class)
					.localAddress(new InetSocketAddress(port))		// 监听端口
					.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel sc) throws Exception {
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
