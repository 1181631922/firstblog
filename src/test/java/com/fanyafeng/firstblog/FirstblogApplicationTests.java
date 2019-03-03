package com.fanyafeng.firstblog;

import com.fanyafeng.firstblog.model.User;
import com.fanyafeng.firstblog.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstblogApplicationTests {

    @Resource
    private UserService userService;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setName("fanyafeng");
        user.setPassword("fanyafeng");
        user.setSex(0);
        user.setSignature("个性签名");

        for (int i = 0; i < 50; i++) {
            userService.addUser(user);
        }
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(1);
        user.setName("你妈知道么");
        user.setPassword("fanyafeng");
        user.setSex(0);
        user.setSignature("高大上离婚谁也拦不住");

        userService.updateByPrimaryKey(user);
    }

    @Test
    public void delUser() {
        userService.deleteByPrimaryKey(5);
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setName("你妈知道么");
        user.setPassword("fanyafeng");
        user.setSex(0);
        user.setSignature("高大上离婚谁也拦不住");
        userService.insert(user);
    }

    @Test
    public void selectByExample() {
//        for (User user : userList) {
//            System.out.println(user.toString());
//        }
        Integer page = 1;
        Integer pageSize = 20;
        PageHelper.startPage(page, pageSize);
        List<User> userList = userService.selectByLikeField("fan");
        System.out.println(userList.toString());
    }

    @Test
    public void selectOrderByClause() {
        //ASC正序
        //DESC倒序
        List<User> userList = userService.selectOrderByClause("sex ASC");
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void selectByCondition() {
        User user = new User();
        user.setPassword("nicai");
        List<User> userList = userService.selectByCondition(user);
        for (User item : userList) {
            System.out.println(item.toString());
        }
    }


}
