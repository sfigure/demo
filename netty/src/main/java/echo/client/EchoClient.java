package echo.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


/**
 * @author jzx
 * @date 2019/01/10 10:22
 * @Description:
 */
public class EchoClient {
	public static void main(String[] argv) throws Exception{
		EventLoopGroup group = new NioEventLoopGroup();
		try{
			Bootstrap b = new Bootstrap();
			b.group(group)
					.channel(NioSocketChannel.class)
					.option(ChannelOption.TCP_NODELAY,true)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ChannelPipeline p = ch.pipeline();
							p.addLast(new EchoClientHandler());
						}
					});
			ChannelFuture f = b.connect("127.0.0.1", 18080).sync();
			f.channel().closeFuture().sync();
		}finally {
			 group.shutdownGracefully();
		}

	}
}
