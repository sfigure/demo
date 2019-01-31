package com.logger;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

/**
 * @author jzx
 * @date 2019/01/31 14:39
 */
public class Main {
    
    
    
    private static Logger logger=Logger.getLogger("com.jdbc.main");
    
    public static void main(String[] argv) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Handler fh = new FileHandler("wombat.log");
        Logger.getLogger("com.jdbc.main").addHandler(fh);
        logger.fine("hi java logggg>>>>>>>>>>>>>>>>>>>>>>>>>>");
        logger.info("aaaaaaaaaaaaaaaaaaaaaaaa");
    }
}
