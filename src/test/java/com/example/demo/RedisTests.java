package com.example.demo;

import com.example.demo.domain.p.Person;
import com.example.demo.domain.p.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
    private RedisTemplate<String,Person> redisTemplate;

	@Test
    public void test()throws Exception{

        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

        // 保存对象
        Person person = new Person("超人", 20);
        redisTemplate.opsForValue().set(person.getUsername(), person);

        person = new Person("蝙蝠侠", 30);

        redisTemplate.opsForValue().set(person.getUsername(), person);

        person = new Person("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(person.getUsername(), person);

        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());
    }

}
