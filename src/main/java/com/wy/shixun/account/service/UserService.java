package com.wy.shixun.account.service;


import com.github.pagehelper.PageInfo;
import com.wy.shixun.account.entity.User;
import com.wy.shixun.common.vo.Result;
import com.wy.shixun.common.vo.Search;

public interface UserService {
    Result<User> insertUser(User user);

    Result<User> updateUser(User user);

    Result<Object> deleteUser(int id);

    User getUserById(int id);

    PageInfo<User> getUsersBySearch(Search search);
}
