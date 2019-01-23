package telnet.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import telnet.server.TelnetServerInitializer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author jzx
 * @date 2019/01/12 17:53
 * @Description:
 */
public class TelnetClient {
    public static void main(String []argv)throws Exception{
        System.out.println("start client...");
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b=new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new TelnetClientInitializer());
            System.out.println("connect...");
            Channel ch = b.connect("127.0.0.1", 18082).sync().channel();
    
            ChannelFuture lastWriteFuture = null;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
            for (; ; ) {
                String line = in.readLine();
                if (line == null) {
                    break;
                }
        
                // Sends the received line to the server.
                lastWriteFuture = ch.writeAndFlush(line + "\r\n");
        
                // If user typed the 'bye' command, wait until the server closes
                // the connection.
                if ("bye".equals(line.toLowerCase())) {
                    ch.closeFuture().sync();
                    break;
                }
            }
    
            // Wait until all messages are flushed before closing the channel.
            if (lastWriteFuture != null) {
                lastWriteFuture.sync();
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }
    }
}
