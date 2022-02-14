package com.universe.unishiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * subject
 * manager
 * realm
 */
@Slf4j
@SpringBootTest
class UniShiroApplicationTests {

    @Test
    void contextLoads() {

    }

    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser(){
        simpleAccountRealm.addAccount("zhangsan","123456");
    }

    /**
     * authentication过程
     * 1、创建Security Manager -> 2、主体提交认证 -> 3、SM认证
     *   -> 4、authenticator认证 -> 5、Realm认证
     *
     */
    @Test
    public void testAuthentication(){
        //1、构建 SecurityManager
        DefaultSecurityManager manager = new DefaultSecurityManager();
        addUser();
        manager.setRealm(simpleAccountRealm);
        //2、主体提交认证
        //设置SM
        SecurityUtils.setSecurityManager(manager);
        //获取当前主体 Subject
        Subject subject = SecurityUtils.getSubject();


        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123456");
        subject.login(token);

        log.info("isAuthenticated:{}",subject.isAuthenticated());

        subject.logout();

        log.info("isAuthenticated:{}",subject.isAuthenticated());

    }

    /**
     *
     */
    @Test
    public void testAuthenticator(){
        simpleAccountRealm.addAccount("zhangsan","123456","admin","user");
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(simpleAccountRealm);

        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123456");
        subject.login(token);

        log.info("isAuthenticated:{}",subject.isAuthenticated());

        subject.checkRoles("admin","user");
    }

}
