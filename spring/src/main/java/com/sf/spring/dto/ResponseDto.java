package com.sf.spring.dto;

import lombok.Data;

/**
 * @author jzx
 * @date 2019/01/31 11:05
 * @Description:
 */
@Data
public class ResponseDto<T> {
    Integer code;
    String msg;
    T data;
}
