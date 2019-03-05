package com.fanyafeng.firstblog.controller.student;

import com.fanyafeng.firstblog.returnmessage.MessageResponse;
import com.fanyafeng.firstblog.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Author： fanyafeng
 * Data： 2019-03-04 20:51
 * Email: fanyafeng@live.cn
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/getTeacherById")
    @ResponseBody
    public MessageResponse getTeacherById(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        return MessageResponse.success().add(studentService.getTeacherById(id));
    }
}
