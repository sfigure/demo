import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;


/**
 * @author jzx
 * @date 2019/01/23 12:21
 * @Description:
 */
public class Main {
    public static void main(String[] argv) {
        Undertow server = Undertow.builder()
                                  .addHttpListener(8080, "localhost")
                                  .setHandler(new HttpHandler() {
                                      public void handleRequest(final HttpServerExchange exchange) throws Exception {
                                          exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                                          exchange.getResponseSender().send("this is undertow");
                                      }
                                  }).build();
        server.start();
    }
}
