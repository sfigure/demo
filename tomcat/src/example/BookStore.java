package example;

import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

/**
 * @author jzx
 * @date 2019/04/24 10:22
 * @Description:
 */
public class BookStore {
    public static Object theStore;
    public Map<String,String> items;
    public Map getItems() {
        return items;
    }
    
    public void doHello(StaplerRequest request, StaplerResponse response ) throws IOException, ServletException {
        response.forward(this,"helloJSP",request);
    }
}
