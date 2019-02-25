package com.fanyafeng.firstblog.controller;

import com.fanyafeng.firstblog.model.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author： fanyafeng
 * Data： 2019-02-22 09:59
 * Email: fanyafeng@live.cn
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/testboot")
public class TestBootController {
    @RequestMapping("getuser")
    public User getUser() {
        User user = new User();
//        user.setName("姓名");
        return user;
    }
}
