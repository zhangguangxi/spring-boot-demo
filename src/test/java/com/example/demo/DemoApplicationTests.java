package com.example.demo;

import com.example.demo.service.UserService;
import com.example.demo.web.BlogProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	private  static final Log log = LogFactory.getLog(DemoApplicationTests.class);
	@Autowired
	private BlogProperties blogProperties;

	@Autowired
    private UserService userService;

	@Before
    public void setUp()
    {
        /**准备，清空user表*/
        userService.deleteAllUsers();
    }

	@Test
	public void contextLoads() {
	}


	@Test
	public void test1() throws Exception {
		Assert.assertEquals("程序猿DD", blogProperties.getName());
		Assert.assertEquals("Spring Boot教程", blogProperties.getTitle());
		Assert.assertEquals("程序猿DD正在努力写《Spring Boot教程》", blogProperties.getDesc());

		log.info("随机数测试输出：");
		log.info("随机字符串 : " + blogProperties.getValue());
		log.info("随机int : "   + blogProperties.getNumber());
		log.info("随机long : "  + blogProperties.getBignumber());
		log.info("随机10以下 : " + blogProperties.getTest1());
		log.info("随机10-20 : "  + blogProperties.getTest2());
	}


    @Test
    public void test() throws Exception {
        // 插入5个用户
        userService.create("a", 1);
        userService.create("b", 2);
        userService.create("c", 3);
        userService.create("d", 4);
        userService.create("e", 5);
        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userService.getAllUsers().intValue());
        // 删除两个用户
        userService.deleteByName("a");
        userService.deleteByName("e");
        // 查数据库，应该有5个用户
        Assert.assertEquals(3, userService.getAllUsers().intValue());
    }


}
