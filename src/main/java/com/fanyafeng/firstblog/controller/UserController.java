package com.fanyafeng.firstblog.controller;

import com.fanyafeng.firstblog.interceptor.LoginInterceptorAnnotation;
import com.fanyafeng.firstblog.model.User;
import com.fanyafeng.firstblog.service.UserService;
import com.fanyafeng.firstblog.service.impl.UserServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Author： fanyafeng
 * Data： 2019-02-23 12:11
 * Email: fanyafeng@live.cn
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    @ResponseBody
    public User toIndex(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        return user;
    }

    @RequestMapping("/showUserList")
    @ResponseBody
    public List<User> showUserList(HttpServletRequest request, Model model) {
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        PageHelper.startPage(pageNum, pageSize);
        return this.userService.selectByLikeField("fan");
    }
}
