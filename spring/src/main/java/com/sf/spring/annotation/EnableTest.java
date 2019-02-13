package com.sf.spring.annotation;

import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;

import java.lang.annotation.*;

/**
 * @author jzx
 * @date 2019/02/13 15:47
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EnableTestAnnotation.class)
public @interface EnableTest {
    /**
     * Apollo namespaces to inject configuration into Spring Property Sources.
     */
    String[] value() default "test";
    
    /**
     * The order of the apollo config, default is {@link Ordered#LOWEST_PRECEDENCE}, which is Integer.MAX_VALUE.
     * If there are properties with the same name in different apollo configs, the apollo config with smaller order wins.
     * @return
     */
    int order() default Ordered.LOWEST_PRECEDENCE;
}
