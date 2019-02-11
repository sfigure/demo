package com.sf.spring.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jzx
 * @date 2019/01/31 11:04
 * @Description:
 */
@Data
public class TestDto implements Serializable {
    String name;
    String age;
}
