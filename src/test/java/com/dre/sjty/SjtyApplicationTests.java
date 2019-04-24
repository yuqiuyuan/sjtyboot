package com.dre.sjty;

import com.dre.sjty.service.SjtyEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SjtyApplicationTests {

	@Autowired
	SjtyEmailService ser;

	@Test
	public void contextLoads() {
		ser.sendTextEmail("yuqiuyuan@czb365.com","测试","Hello World～！");
	}

}

