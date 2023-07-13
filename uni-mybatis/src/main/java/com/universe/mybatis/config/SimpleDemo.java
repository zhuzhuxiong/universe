package com.universe.mybatis.config;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
            User user = mapper.selectUser3(1, user1);
//            System.out.println(user.toString());

            HashMap<String, Object> map = new HashMap<>();
            map.put("name", "Jone");
            map.put("age", 18);
            User user2 = mapper.selectUser4(map);
            System.out.println(user2.toString());

//            List<User> users = mapper.selectList();
//            System.out.println(Json.pretty(users));

            PageHelper.startPage(1, 3);
            List<User> list = mapper.selectList(1,3);
            PageInfo<User> info = new PageInfo<>(list, 3);
            System.out.println("当前页码：" + info.getPageNum());
            System.out.println("每页的记录数：" + info.getPageSize());
            System.out.println("总记录数：" + info.getTotal());
            System.out.println("总页码：" + info.getPages());
            System.out.println("是否第一页：" + info.isIsFirstPage());
            System.out.println("连续显示的页码：");
            int[] nums = info.getNavigatepageNums();
            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
