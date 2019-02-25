package com.fanyafeng.firstblog.service;

import com.fanyafeng.firstblog.model.User;
import org.springframework.stereotype.Service;

/**
 * Author： fanyafeng
 * Data： 2019-02-23 11:58
 * Email: fanyafeng@live.cn
 */
public interface UserService {
    User getUserById(int userId);

    boolean addUser(User record);
}
