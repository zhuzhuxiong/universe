package com.universe.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and().authorizeRequests().anyRequest().authenticated();






    }

    public static void main(String[] args) throws Exception {
//        while (true) {
//            String name = "";
//        }
//        HttpSecurity security = new HttpSecurity();
//        new SecurityConfig().configure(security);

        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat dateFm = new SimpleDateFormat("EEE", Locale.ENGLISH);
        String week = dateFm.format(date);
        System.out.println(week);
    }
}
