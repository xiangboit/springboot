package com.example.ssh.controller;

import com.example.ssh.domain.User;
import com.example.ssh.service.UserService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/16.
 */
@RestController
public class UserMapping {
    private static Logger logger= LoggerFactory.getLogger(UserMapping.class);
    Map<String, Object> maps;
    @Autowired
    private UserService userService;


    @ApiOperation(value = "获取用户列表", notes = "获取所有用户数据")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页数",name="pageindex",dataType = "int",paramType = "query",required = true),
            @ApiImplicitParam(value = "条数",name="pagesize",dataType = "int",paramType = "query",required = true),
    })
    @RequestMapping(value = "/userList", method = RequestMethod.POST)
    public Map<String, Object> userList(int pageindex,int pagesize) {
        PageHelper.startPage(pageindex, pagesize);
        List<User> userList = userService.getUserlist();
        maps = new HashMap<>();
        maps.put("obj", userList);
        maps.put("msg", "数据获取成功");
        return maps;
    }

    @ApiOperation(value = "用户信息详情", notes = "根据用户唯一id，获取用户的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户唯一id", name = "id", required = true, dataType = "Long",paramType = "query")
    })
    @RequestMapping(value = "/getDetail", method = RequestMethod.POST)
//
    public User getDetail(@RequestParam Long id) {
        logger.info("=================================="+id);

        User user = userService.getUserById(id);
        return user;
    }

    @ApiOperation(value = "数据删除接口", notes = "根据用户id，删除用户记录")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户id", name = "id", required = true, dataType = "Long")
    })
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestParam(value = "id", required = true,defaultValue="0") Long id) {
        userService.delete(id);
    }

    @ApiOperation(value = "更新用户信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody User user) {
        logger.info("=================================="+user);
        userService.update(user);
        return "修改成功";
    }
    @ApiOperation(value = "创建用户记录")
    @RequestMapping(value = "/createUser",method = RequestMethod.POST)
    public void createUser(@RequestBody User user){
        logger.info(user.toString());
        userService.create(user);
    }
}
