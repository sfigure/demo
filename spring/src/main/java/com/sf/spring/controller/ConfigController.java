package com.sf.spring.controller;

import com.sf.spring.config.TestConfiguration;
import com.sf.spring.dto.ResponseDto;
import com.sf.spring.service.JooqService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.Configuration;

/**
 * @author jzx
 * @date 2019/01/31 10:44
 * @Description:
 */
@RestController
@RequestMapping("conf")
@Data
public class ConfigController extends BaseController {
    
    @Value("${testconfig.name}")
    String name;
    
    @Autowired
    TestConfiguration testConfiguration;
    
    @RequestMapping("/test")
    public ResponseDto test() throws Exception {
        Object object=new Object();
        return success(testConfiguration.getName());
    }
}
