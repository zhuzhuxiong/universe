package com.universe.spring.annocation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 注解（demo）
 * @author lx
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface EchoAnno {

    /**
     * 输出 内容
     */
   public String value() default "1";
}
