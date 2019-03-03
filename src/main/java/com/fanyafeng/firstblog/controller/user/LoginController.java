package com.fanyafeng.firstblog.controller.user;

import com.fanyafeng.firstblog.model.User;
import com.fanyafeng.firstblog.returnmessage.MessageResponse;
import com.fanyafeng.firstblog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Author： fanyafeng
 * Data： 2019-03-03 19:26
 * Email: fanyafeng@live.cn
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public MessageResponse login(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String passWord = request.getParameter("passWord");

        User user = userService.getUserById(userId);
        if (user != null) {
            if (user.getPassword().equals(passWord)) {
                return MessageResponse.success().add("isLogin", true);
            }
        }
        return MessageResponse.fail().add("isLogin", false);
    }

}
