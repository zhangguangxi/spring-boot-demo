package com.example.demo.mybatis;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper
{
    @Select("SELECT * FROM user WHERE NAME = #{name}")
    User findByName(@Param("name")String name);

    @Results({
            @Result(property = "name",column = "name"),
            @Result(property = "age",column = "age")
    })

    @Select("SELECT name,age FROM user")
    List<User> findAll();

    @Insert("INSERT INTO user(name,age) VALUES(#{name},#{age})")
    int insert(@Param("name")String name,@Param("age")Integer age);

    @Update("UPDATE user set age=#{age} WHERE name=#{name}")
    void update(User user);

    @Insert("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);

    @Insert("INSERT INTO user(name,age)VALUES(#{name},#{age})")
    int insertByUser(User user);

    @Insert("INSERT INTO user(name,age)VALUES(#{name,jdbcType=VARCHAR},#{age,jdbcType=INTEGER})")
    int insertByMap(Map<String,Object> map);
}
