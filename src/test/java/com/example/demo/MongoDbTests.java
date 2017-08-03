package com.example.demo;

import com.example.demo.domain.mongodb.User;
import com.example.demo.domain.mongodb.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDbTests
{
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setup()
    {
        userRepository.deleteAll();
    }

    @Test
    public  void test() throws Exception{

        /**创建三个User,并验证User总数*/
        userRepository.save(new User(1L,"zhang",30));
        userRepository.save(new User(2L,"guang",40));
        userRepository.save(new User(3L,"xi",50));
        Assert.assertEquals(3,userRepository.findAll().size());

        /**删除一个User,再验证User总数*/
        User u = userRepository.findOne(1l);
        userRepository.delete(u);
        Assert.assertEquals(2,userRepository.findAll().size());

        /**再删除一个User,再验证User总数*/
         u = userRepository.findByUsername("guang");
        userRepository.delete(u);
        Assert.assertEquals(1,userRepository.findAll().size());

    }

}
