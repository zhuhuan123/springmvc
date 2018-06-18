package stdemo;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.std.model.User;
import com.std.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TesMy{
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void test() {
		User user = new User();
		user.setAddress("�㶫����");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setUsername("�ϻ�");
		userService.insertUser(user);
	}
	
	@Test
	public void t() {
		
	}
}
