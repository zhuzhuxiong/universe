package com.universe.mybatis.mapper;

import com.universe.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dianxiaoer
 * @since 2022-12-14
 */
public interface UserMapper {

    /** 单个参数 */
    User selectById(Integer id);

    @Select("select * from user where id=#{id}")
    User getById(Integer id);

    /** 多个参数 */
    User selectUser(String name, Integer age);

    User selectUser1(@Param("eman") String name, Integer age);

    User selectUser2(User user);

    User selectUser3(Integer id, User user);

    List<User> selectList();

    User selectUser4(Map map);

}
