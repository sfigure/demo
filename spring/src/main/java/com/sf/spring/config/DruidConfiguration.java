package com.sf.spring.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.validation.constraints.NotNull;

/**
 * @author jzx
 * @date 2019/02/13 15:18
 * @Description:
 */
@Configuration
@ConfigurationProperties("spring.datasource")
@Data
public class DruidConfiguration {


}
