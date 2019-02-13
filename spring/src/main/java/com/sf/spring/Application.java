package com.sf.spring;

import com.sf.spring.annotation.EnableTest;
import com.sf.spring.dao.UserDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 * @author jzx
 * @date 2019/01/31 10:44
 * @Description:
 */

@SpringBootApplication
@MapperScan("com.sf.spring.dao")
@EnableAsync
@EnableTest
public class Application{
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}

