package com.universe.mybatis.config;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.universe.mybatis.entity.User;

public class IdConfig implements IdentifierGenerator {

    @Override
    public Number nextId(Object entity) {
        String name = entity.getClass().getName();
        return new DefaultIdentifierGenerator().nextId(entity);
    }

    public static void main(String[] args) {
        Number number = new IdConfig().nextId(User.class);
        System.out.println(number);
    }
}
