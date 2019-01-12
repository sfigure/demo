package telnet.server;

import io.netty.channel.*;

/**
 * @author jzx
 * @date 2019/01/12 18:06
 * @Description:
 */
@ChannelHandler.Sharable
public class TelnetServerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String request) throws Exception {
        String response;
        boolean close=false;
        if(request.length()==0){
            response = "Please type something.\r\n";
        }
        if("bye".equals(request.toLowerCase())){
            response = "Have a good day!\r\n";
            close = true;
        }else {
            response = "Did you say '" + request + "'?\r\n";
        }
    
        ChannelFuture future = ctx.write(response);
        if(close){
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
