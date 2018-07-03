package com.service;

import com.entity.Student;

public interface StudentService  {
    /**
     * 删除
     *
     * @param user 用户对象
     * @return 操作结果
     */
    Student saveOrUpdate(Student user);

    /**
     * 添加
     *
     * @param id key值
     * @return 返回结果
     */
    Student get(Integer id);

    /**
     * 删除
     *
     * @param id key值
     */
    void delete(Integer id);

    String get();
}
