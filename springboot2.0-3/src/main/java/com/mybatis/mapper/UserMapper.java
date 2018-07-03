package com.mybatis.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User>{

}
