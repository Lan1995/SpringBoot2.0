package com.service.impl;

import com.entity.Student;
import com.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private static final Map<Integer, Student> DATABASES = new HashMap<>();

    static {
        DATABASES.put(1, new Student(1, "u1", "p1"));
        DATABASES.put(2, new Student(2, "u2", "p2"));
        DATABASES.put(3, new Student(3, "u3", "p3"));
    }

    @Cacheable(value = "student", key = "#id")
    @Override
    public Student get(Integer id) {
        // 我们就假设它是从数据库读取出来的
        log.info("进入 get 方法");
        return DATABASES.get(id);
    }

    @CachePut(value = "student", key = "#student.id")
    @Override
    public Student saveOrUpdate(Student student) {
        DATABASES.put(student.getId(), student);
        log.info("进入 saveOrUpdate 方法");
        return student;
    }

    @CacheEvict(value = "student", key = "#id")
    @Override
    public void delete(Integer id) {
        DATABASES.remove(id);
        log.info("进入 delete 方法");
    }
}
