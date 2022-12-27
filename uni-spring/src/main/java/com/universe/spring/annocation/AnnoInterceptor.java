package com.universe.spring.annocation;

import com.universe.spring.controller.LoginController;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Optional;

/**
 * @author lx
 */
@Configuration
public class AnnoInterceptor implements ApplicationListener<ContextRefreshedEvent> {

    public void echo(Class cl) {
        Field[] fields = LoginController.class.getDeclaredFields();
        for (Field f : fields) {
            String value = f.getAnnotation(EchoAnno.class).value();
            System.out.println("echo:"+ value);
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        echo(event.getClass());
    }
}
