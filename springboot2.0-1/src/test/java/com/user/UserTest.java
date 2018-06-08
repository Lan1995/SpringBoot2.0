package com.user;

import com.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.mapper.UserMapper;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1() throws Exception{
        User user1 = new User();
        user1.setUsername("u1");
        user1.setPassword("pa");

        User user2 = new User();
        user2.setUsername("u1");
        user2.setPassword("pa");

        User user3 = new User();
        user3.setUsername("u1");
        user3.setPassword("pa");
        final int row1 = userMapper.insert(user1);
        log.info("[添加结果] - [{}]", row1);
        final int row2 = userMapper.insert(user2);
        log.info("[添加结果] - [{}]", row2);
        final int row3 = userMapper.insert(user3);
        log.info("[添加结果] - [{}]", row3);

        userMapper.insertSelective(new User("u1","p1"));
        userMapper.insertSelective(new User("u1","p1"));
        userMapper.insertSelective(new User("u1","p1"));
        userMapper.insertSelective(new User("u1","p1"));
        userMapper.insertSelective(new User("u1","p1"));
        userMapper.insertSelective(new User("u1","p1"));
        userMapper.insertSelective(new User("u1","p1"));

        // TODO 分页 + 排序 this.userMapper.selectAll() 这一句就是我们需要写的查询，有了这两款插件无缝切换各种数据库
        final PageInfo<Object> pageInfo = PageHelper.startPage(1, 10).setOrderBy("id desc").doSelectPageInfo(() -> this.userMapper.selectAll());
        log.info("[lambda写法] - [分页信息] - [{}]", pageInfo.toString());

        PageHelper.startPage(1, 10).setOrderBy("id desc");
        final PageInfo<User> userPageInfo = new PageInfo<>(this.userMapper.selectAll());
        log.info("[普通写法] - [{}]", userPageInfo);
    }
}
