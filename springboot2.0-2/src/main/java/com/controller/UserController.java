package com.controller;

import com.battcn.swagger.properties.ApiDataType;
import com.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "1.1", description = "用户管理", value = "用户管理")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    @ApiOperation(value = "条件查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = ApiDataType.STRING),
            @ApiImplicitParam(name = "password", value = "密码", dataType = ApiDataType.STRING),
    })
    public User query(String username, String password) {
        return new User(username, password);
    }

    @GetMapping(value = "{id}")
    @ApiOperation(value = "根据ID获取用户")
    @ApiImplicitParam(name = "id", value = "主键", dataType = ApiDataType.INT)
    public User getUserById(@PathVariable("id") Integer id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    @GetMapping(value = "del/{id}")
    @ApiOperation(value = "根据ID删除用户")
    public User delUserById(@PathVariable("id") Integer id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    @PostMapping(value = "addUser")
    @ApiOperation(value = "新增用户")
    public int addUser(@RequestBody User user) {
        logger.info("add success");
        return 200;
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "修改用户（DONE）")
    public void put(@PathVariable Long id, @RequestBody User user) {
        logger.info("如果你不想写 @ApiImplicitParam 那么 swagger 也会使用默认的参数名作为描述信息 ");
    }
}
