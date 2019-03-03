package com.fanyafeng.firstblog.service;

import com.fanyafeng.firstblog.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-02-23 11:58
 * Email: fanyafeng@live.cn
 */
public interface UserService {
    /**
     * 根据用户id获取用户信息
     *
     * @param userId
     * @return
     */
    User getUserById(int userId);

    /**
     * 添加用户
     *
     * @param record
     * @return
     */
    boolean addUser(User record);

    /**
     * 根据id更新用户信息
     *
     * @param user
     * @return
     */
    boolean updateByPrimaryKey(User user);

    /**
     * 根据用户id删除用户信息
     *
     * @param userId
     * @return
     */
    boolean deleteByPrimaryKey(int userId);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    boolean insert(User user);

    /**
     * 模糊查询
     *
     * @param likeField
     * @return
     */
    List<User> selectByLikeField(String likeField);

    /**
     * 按照字段排序
     *
     * @param orderByClause
     * @return
     */
    List<User> selectOrderByClause(String orderByClause);

    /**
     * 通过不确定条件查询
     * 可以模糊也可以确定条件
     *
     * @param user
     * @return
     */
    List<User> selectByCondition(User user);

//    List<User> selectByPageNumber()

}
