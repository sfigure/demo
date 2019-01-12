package telnet.client;

import io.netty.channel.*;

/**
 * @author jzx
 * @date 2019/01/12 18:06
 * @Description:
 */
@ChannelHandler.Sharable
public class TelnetClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
     System.err.println(msg);
    }
}
