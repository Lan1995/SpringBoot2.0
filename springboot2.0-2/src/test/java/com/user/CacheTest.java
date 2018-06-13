package com.user;

import com.entity.Student;
import com.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CacheTest {

    @Autowired
    private StudentService studentService;


    @Test
    public void get() {
        final Student user = studentService.saveOrUpdate(new Student(5, "u5", "p5"));
        log.info("[saveOrUpdate] - [{}]", user);
        final Student user1 = studentService.get(5);
        log.info("[get] - [{}]", user1);
        studentService.delete(5);
    }
}
