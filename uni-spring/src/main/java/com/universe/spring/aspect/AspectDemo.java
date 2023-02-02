package com.universe.spring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面demo
 * 1、注解功能
 * 2、表达式
 * @author lx
 */
@Slf4j
@Aspect
@Component
public class AspectDemo {

    /**
     * @Pointcut 参数：value；argNames
     * value：
     *  args():
     *  @args():
     *  target():
     *  @target():
     *  within():
     *  @within():
     *  this():
     *  @annotation()：
     *  **execution()：
     *      ():(..) 表示所有参数
     *          ()  代表一个参数
     *     (,String) 代表第一个参数为任意参数，第二个参数为String
     *
     *
     */
    @Pointcut(value = "execution(* com.universe.spring.controller.*.*(..))")
//    @Pointcut(argNames = "")
//    @Pointcut(value = "@annotation()")
//    @Pointcut(value = "execution(public * *(..))")
    private void pointCut() {
    }
//
//    @Before(value = "pointCut()")
//    public void beforePoint() {
//        log.info("beforePoint:切点前");
//    }
//
//    @After(value = "pointCut()")
//    public void afterPoint() {
//        log.info("afterPoint:切点后");
//    }
//
//    @Around(value = "pointCut()")
//    public void aroundPoint(ProceedingJoinPoint pjp){
//        log.info("aroundPoint:包围你");
//    }


}
