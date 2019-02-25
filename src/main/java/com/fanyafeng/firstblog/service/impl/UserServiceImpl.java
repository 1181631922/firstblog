package com.fanyafeng.firstblog.service.impl;

import com.fanyafeng.firstblog.dao.UserMapper;
import com.fanyafeng.firstblog.model.User;
import com.fanyafeng.firstblog.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-02-23 11:59
 * Email: fanyafeng@live.cn
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public boolean addUser(User record) {
        boolean result = false;
        try {
            userMapper.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
