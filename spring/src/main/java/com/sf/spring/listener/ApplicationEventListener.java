package com.sf.spring.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author jzx
 * @date 2019/02/11 16:08
 * @Description:
 */
@Slf4j
public class ApplicationEventListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
      log.info("事件:{}",applicationEvent.toString());
    }
}
