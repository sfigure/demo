package com.sf.spring.controller;

import com.sf.spring.dto.ResponseDto;
import com.sf.spring.dto.TestDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jzx
 * @date 2019/01/31 10:44
 * @Description:
 */
@RestController
@RequestMapping("test")
public class TestController extends BaseController {
    
    @RequestMapping("/test")
    public ResponseDto test() {
        TestDto testDto = new TestDto();
        testDto.setName("test");
        testDto.setAge("18");
        return sussess(testDto);
    }
}
