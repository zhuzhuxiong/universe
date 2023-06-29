package com.universe.mybatis.config;

import com.universe.mybatis.entity.User;
import com.universe.mybatis.mapper.UserMapper;
import io.swagger.v3.core.util.Json;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

/**
 * @author
 */
public class SimpleDemo {

    public static void main(String[] args) {

        String resource = "mybatis-config.xml";
        Reader reader;

        try {
            //1、
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            //2、
            SqlSession session = factory.openSession();
//            //3、
//            User one = (User)session.selectOne("com.universe.mybatis.mapper.UserMapper.selectById", 1);
//            System.out.println(one);

            UserMapper mapper = session.getMapper(UserMapper.class);
            System.out.println(mapper.getClass());

//            User user = mapper.getById(1);
            User user1 = new User();
            user1.setName("Jone");
            user1.setAge(18);
            User user = mapper.selectUser3(1,user1);
//            System.out.println(user.toString());

            HashMap<String, Object> map = new HashMap<>();
            map.put("name","Jone");
            map.put("age",18);
            User user2 = mapper.selectUser4(map);
            System.out.println(user2.toString());

//            List<User> users = mapper.selectList();
//            System.out.println(Json.pretty(users));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
