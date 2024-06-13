package com.example.demo;

import com.example.demo.model.user.User;
import com.example.demo.model.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
class AndroidLoginPracticeApplicationTests {

	@Autowired
	private UserService userDao;
	@Test
	void addUserTest() {
		User user=new User();
		user.setId("헐렐레");
		user.setPassword("987456");
		user.setEmail("iyy1001");

		userDao.save(user);
	}
	@Test
	void getAllUsersAndDeleteThem(){
		List<User> users= userDao.getAllUsers(); // 받아온 걸 users에 저장해서
		for (User user: users){
			userDao.delete(user); // 다 지움
		}
	}
	void contextLoads() {
	}

}
