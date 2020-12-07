package com.socket.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 *@author sunq
 *@date2020/11/3 16:21
 *@Description
 */
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {


	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
		System.out.println("client accept：" + byteBuf.toString(CharsetUtil.UTF_8));
	}


	// channel 活跃后，做业务处理
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush(Unpooled.copiedBuffer("hello netty", CharsetUtil.UTF_8));
	}
}
