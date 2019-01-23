package http.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpHeaderValues.KEEP_ALIVE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;

/**
 * @author jzx
 * @date 2019/01/23 10:00
 * @Description:
 */
public class TestServerHandler extends ChannelInboundHandlerAdapter {
    
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("处理请求");
        if (msg instanceof FullHttpRequest) {
            FullHttpRequest req = (FullHttpRequest) msg;
            boolean keepAlive = HttpUtil.isKeepAlive(req);
            ByteBuf byteBuf = Unpooled.buffer(1024);
            byteBuf.writeCharSequence("hi netty", CharsetUtil.UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, OK, byteBuf);
            if (keepAlive) {
                response.headers().set(CONTENT_TYPE, "text/html");
                response.headers().setInt(CONTENT_LENGTH, response.content().readableBytes());
                response.headers().set(CONNECTION, KEEP_ALIVE);
                ctx.write(response);
            } else {
                ctx.write(response).addListener(ChannelFutureListener.CLOSE);
            }
        }
        
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
