package time.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author jzx
 * @date 2019/01/10 09:49
 * @Description:
 */


/**
 * @author jzx
 * @date 2019/01/10 09:49
 * @Description:
 */
public class TimeServer {
	public static void main(String[] argv) throws Exception{
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		final TimeServerHandler serverHandler = new TimeServerHandler();
		try{
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup,workerGroup)
					.channel(NioServerSocketChannel.class)
					.option(ChannelOption.SO_BACKLOG, 100)
					.handler(new LoggingHandler(LogLevel.INFO))
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel socketChannel) throws Exception {
							ChannelPipeline p = socketChannel.pipeline();
							p.addLast(serverHandler);
						}
					});
			ChannelFuture f = b.bind(18081).sync();
			f.channel().closeFuture().sync();

		}catch (Exception e){
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
