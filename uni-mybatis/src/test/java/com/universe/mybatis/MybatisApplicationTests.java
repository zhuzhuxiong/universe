package com.universe.mybatis;


import com.universe.mybatis.entity.User;
import com.universe.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
//        Assert.assertEquals(5, users.size());
        users.forEach(System.out::println);

    }

}
