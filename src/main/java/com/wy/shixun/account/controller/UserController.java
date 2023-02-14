package com.wy.shixun.account.controller;

import com.github.pagehelper.PageInfo;
import com.wy.shixun.account.entity.User;
import com.wy.shixun.account.service.UserService;
import com.wy.shixun.common.vo.Result;
import com.wy.shixun.common.vo.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.crypto.interfaces.PBEKey;

@RestController
@RequestMapping("/api/account")
public class UserController {
    @Autowired
    private UserService userService;


    //{"userName":"hujiang", "password":"111111"}
    @PostMapping(value = "/user",consumes = MediaType.APPLICATION_JSON_VALUE )
    public Result<User> insertUser(User user){
        return userService.insertUser(user);
    }

    @PutMapping(value="/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping(value = "/user/{id}")
    public Result<Object> deleteUserById(@PathVariable int id){
        return userService.deleteUser(id);
    }

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping(value = "/users",consumes = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<User> getUserBySearch(@RequestBody Search search){
        return userService.getUsersBySearch(search);
    }

}
