package com.example.ssh.respiratory;

import com.example.ssh.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2017/11/17.
 */
@Mapper
public interface UserRespriatory {
    @Select("select * from user")
    List<User> getUserlist();
    @Select("select * from user where id =#{id}")
    User getUserById(Long id);
    @Delete("delete from user where id =#{id}")
    void delete(Long id);
    @Update("UPDATE USER SET NAME=#{name},AGE=#{age},SEX=#{sex} WHERE ID =#{id}")
    void update(User user);
    @Select("INSERT INTO user(name,nickame,sex,age) VALUES (#{name}, null,#{sex}, #{age})")
    void create(User user);
}
