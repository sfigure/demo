package example;
import org.kohsuke.stapler.Stapler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebAppMain implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent event) {
        // BookStore.theStore is the singleton instance of the application
        Stapler.setRoot(event,BookStore.theStore);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }
}