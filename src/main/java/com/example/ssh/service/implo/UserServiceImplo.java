package com.example.ssh.service.implo;

import com.example.ssh.domain.User;
import com.example.ssh.respiratory.UserRespriatory;
import com.example.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/17.
 */
@Service
public class UserServiceImplo implements UserService {
    @Autowired
    private UserRespriatory userRespriatory;
    @Override
    public List<User> getUserlist() {
        List<User> userList=userRespriatory.getUserlist();
        return userList;
    }

    @Override
    public User getUserById(Long id) {
        User user=userRespriatory.getUserById(id);
        return user;
    }

    @Override
    public void delete(Long id) {
        System.out.println(id);
        userRespriatory.delete(id);
    }

    @Override
    public void update(User user) {
        System.out.println(""+user);
        userRespriatory.update(user);
    }

    @Override
    public void create(User user) {
        userRespriatory.create(user);
    }
}
