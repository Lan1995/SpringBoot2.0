package com;

import com.entity.Student;
import com.entity.User;
import com.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

	@Autowired
	private StudentService service;

	@Test
	public void contextLoads() {

		service.get(1);
		service.saveOrUpdate(new Student(6,"6","6"));
		service.delete(1);
		System.out.println(service.get(1));
		service.get();
		System.out.println(service.get());
		System.out.println(service.get());
		try {
			this.wait(1000*30);
		} catch (InterruptedException e) {
			System.out.println("中断异常");
		}
	}

}
