package com.fanyafeng.firstblog.service.impl;

import com.fanyafeng.firstblog.dao.UserMapper;
import com.fanyafeng.firstblog.model.User;
import com.fanyafeng.firstblog.model.UserExample;
import com.fanyafeng.firstblog.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean updateByPrimaryKey(User user) {
        boolean result = false;
        try {
            userMapper.updateByPrimaryKey(user);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteByPrimaryKey(int userId) {
        boolean result = false;
        try {
            userMapper.deleteByPrimaryKey(userId);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Override
    public boolean insert(User user) {
        boolean result = false;
        try {
            userMapper.insert(user);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<User> selectByLikeField(String likeField) {
        UserExample example = new UserExample();
        example.createCriteria().andNameLike('%' + likeField + '%');
        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> selectOrderByClause(String orderByClause) {
        UserExample example = new UserExample();
        example.setOrderByClause(orderByClause);
        return userMapper.selectByExample(example);
    }

    /**
     * 通过不确定条件查询
     *
     * @param user
     * @return
     */
    @Override
    public List<User> selectByCondition(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(user.getName())) {
            criteria.andNameEqualTo(user.getName());
        }
        if (!StringUtils.isEmpty(user.getPassword())) {
            criteria.andPasswordLike('%' + user.getPassword() + '%');
        }
        return userMapper.selectByExample(example);
    }
}
