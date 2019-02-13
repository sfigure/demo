package com.sf.spring.controller;

import com.sf.spring.dao.UserDao;
import com.sf.spring.dataobject.User;
import com.sf.spring.dto.ResponseDto;
import com.sf.spring.service.JooqService;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jzx
 * @date 2019/01/31 10:44
 * @Description:
 */
@RestController
@RequestMapping("jooq")
public class JooqController extends BaseController {
    
    @Autowired
    JooqService jooqService;
    
    @RequestMapping("/test")
    public ResponseDto test() throws Exception {
        jooqService.test();
        return success();
    }
}
