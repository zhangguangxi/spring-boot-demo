/*
package com.example.demo.service.impl;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    */
/**
     * 新增一个用户
     *
     * @param name
     * @param age
     *//*

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", name, age);
    }

    */
/**
     * 根据name删除一个用户高
     *
     * @param name
     *//*

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from USER where NAME = ?", name);
    }

    */
/**
     * 获取用户总量
     *//*

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    */
/**
     * 删除所有用户
     *//*

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER");
    }
}
*/
