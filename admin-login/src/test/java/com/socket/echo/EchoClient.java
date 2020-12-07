package com.socket.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 *@author sunq
 *@date2020/11/3 16:33
 *@Description
 */
public class EchoClient {

	private final int port;
	private final String host;

	public EchoClient(int port, String host) {
		this.port = port;
		this.host = host;
	}

	public static void main(String[] args) throws InterruptedException {
		new EchoClient(9999, "127.0.0.1").start();
	}

	public void start() throws InterruptedException {
		// 线程组
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			// 客户端启动准备
			Bootstrap b = new Bootstrap();
			// 指定使用nio的通信模式，
			b.group(group).channel(NioSocketChannel.class)
					.remoteAddress(new InetSocketAddress(host, port))		// 指定服务器ip 和 端口
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel sc) throws Exception {
							sc.pipeline().addLast(new EchoClientHandler());
						}
					});
			// 异步绑定到服务器，sync会阻塞到完成
			ChannelFuture future = b.connect().sync();
			// 阻塞当前线程，直到客户端的channel被关闭
			future.channel().closeFuture().sync();
		}finally {
			group.shutdownGracefully().sync();
		}
	}

}
