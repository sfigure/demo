package com.sf.spring.dataobject;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jzx
 * @date 2019/02/11 14:52
 * @Description:
 */
@Data
public class User implements Serializable {
    private Long id;
    
    private String name;
    
    private Integer age;
}
