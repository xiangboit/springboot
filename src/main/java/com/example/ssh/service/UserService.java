package com.example.ssh.service;

import com.example.ssh.domain.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/11/16.
 */
public interface UserService {
    /**
     * @return 用户信息列表
     */
    List<User> getUserlist();

    /**
     *
     * @param id 用户唯一id
     * @return 用户对象
     */
    User getUserById(Long id);

    /**
     *
     * @param id 用户唯一id
     */
    void delete(Long id);

    /**
     *
     * @param user 用户实体
     */
    void update(User user);

    /**
     *
     * @param user 用户实体
     */
    void create(User user);
}
