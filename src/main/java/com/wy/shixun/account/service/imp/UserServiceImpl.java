package com.wy.shixun.account.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wy.shixun.account.dao.UserDao;
import com.wy.shixun.account.entity.User;
import com.wy.shixun.account.service.UserService;
import com.wy.shixun.common.vo.Result;
import com.wy.shixun.common.vo.Search;
import com.wy.shixun.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public Result<User> insertUser(User user) {
        //根据用户名查询用户是否存在，存在返回错误信息
        User temp = userDao.getUserByUserName(user.getUserName());
        if(temp!=null){
            return Result.failed("用户名重复");
        }
        //初始化user时间属性
        user.setCreateDate(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        user.setPassword(MD5Util.getMD5(user.getPassword()));

        //插入user
        userDao.insertUser(user);
        //返回结果
        return Result.ok(user);
    }
    @Override
    @Transactional
    public Result<User> updateUser(User user){
        //根据用户名查询用户是否存在，判断是否和别人名字一样
        User temp = userDao.getUserByUserName(user.getUserName());
        if(temp!=null && temp.getId()!= user.getId()){
            return Result.failed("用户名重复");
        }
        //初始化user相关属性
        user.setUpdateTime(LocalDateTime.now());
        user.setPassword(MD5Util.getMD5(user.getPassword()));

        userDao.updateUser(user);

        return Result.ok(user);
    }

    @Override
    @Transactional
    public Result<Object> deleteUser(int id) {
        //删除对应id的user
        userDao.deleteUserById(id);
        //返回结果
        return Result.ok();
    }

    @Override
    public User getUserById(int id) {

        return userDao.getUserById(id);
    }

    @Override
    public PageInfo<User> getUsersBySearch(Search search) {
        //初始化search对象
        search.initSearch();
        //开启分页
        PageHelper.startPage(search.getCurrentPage(),search.getPageSize());
        //返回结果
//        return new PageInfo<>(userDao.getUserBySearch(search));
        return new PageInfo<>(Optional
                .ofNullable(userDao.getUserBySearch(search))
                .orElse(Collections.emptyList()));
    }
}
