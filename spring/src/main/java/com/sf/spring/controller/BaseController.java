package com.sf.spring.controller;

import com.sf.spring.dto.ResponseDto;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jzx
 * @date 2019/01/31 10:44
 * @Description:
 */
@RestController
public class BaseController {
    ResponseDto success(Object data){
        ResponseDto responseDto=new ResponseDto();
        responseDto.setCode(0);
        responseDto.setMsg("");
        responseDto.setData(data);
        return  responseDto;
    }
    ResponseDto success(){
        ResponseDto responseDto=new ResponseDto();
        responseDto.setCode(0);
        responseDto.setMsg("");
        responseDto.setData("");
        return  responseDto;
    }
    ResponseDto error(String msg){
        ResponseDto responseDto=new ResponseDto();
        responseDto.setCode(1);
        responseDto.setMsg(msg);
        responseDto.setData(new Object());
        return  responseDto;
    }
}
