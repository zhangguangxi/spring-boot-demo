package com.example.demo;

import com.example.demo.domain.p.UserRepository;
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

	@Autowired
	private UserRepository userRepository;

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
    public void test2() throws Exception {
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

    @Test
	public void test3() throws  Exception
	{
		/*创建10条记录**/
		 userRepository.save(new com.example.demo.domain.p.User("AAA",10));
		 userRepository.save(new com.example.demo.domain.p.User("BBB",20));
		 userRepository.save(new com.example.demo.domain.p.User("CCC",30));
		 userRepository.save(new com.example.demo.domain.p.User("DDD",40));
		 userRepository.save(new com.example.demo.domain.p.User("EEE",50));
		 userRepository.save(new com.example.demo.domain.p.User("FFF",60));
		 userRepository.save(new com.example.demo.domain.p.User("GGG",70));
		 userRepository.save(new com.example.demo.domain.p.User("HHH",80));
		 userRepository.save(new com.example.demo.domain.p.User("III",90));
		 userRepository.save(new com.example.demo.domain.p.User("JJJ",100));

		/**测试findAll，查询所有记录*/
		Assert.assertEquals(10,userRepository.findAll().size());

		/**测试findByName，查询是哪个名为FFF的User*/
		Assert.assertEquals(60,userRepository.findByName("FFF").getAge().intValue());

		/**测试findUser，查询姓名为FFF的User*/
		Assert.assertEquals(60,userRepository.findUser("FFF").getAge().intValue());

		/**测试findByNameAndAge,查询姓名为FFF并且年龄为60的User*/
		Assert.assertEquals("FFF",userRepository.findByNameAndAge("FFF",60).getName());

		/**测试删除姓名为AAA的User*/
		userRepository.delete(userRepository.findByName("AAA"));

		/**测试findAll，查询所有记录，验证上面的删除是否成功*/
		Assert.assertEquals(9,userRepository.findAll().size());

	}

}
