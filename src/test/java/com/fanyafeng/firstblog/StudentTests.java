package com.fanyafeng.firstblog;

import com.fanyafeng.firstblog.model.Student;
import com.fanyafeng.firstblog.model.Teacher;
import com.fanyafeng.firstblog.service.StudentService;
import com.fanyafeng.firstblog.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Author： fanyafeng
 * Data： 2019-03-04 21:53
 * Email: fanyafeng@live.cn
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTests {

    @Resource
    private StudentService studentService;

    @Resource
    private TeacherService teacherService;

    @Test
    public void addStudent() {
        Student student = new Student();
        for (int i = 0; i < 30; i++) {
            student.setAge(i);
            student.setCourse("数学" + i);
            student.setName("姓名" + i);
            student.setSex(i % 2);
            student.setIdTeacher(1);
            studentService.addStudent(student);
        }
    }

    @Test
    public void addTeacher() {
        Teacher teacher = new Teacher();
        for (int i = 0; i < 30; i++) {
            teacher.setCourse("语文" + i);
            teacher.setIdStudent(1);
            teacher.setTeacherName("老师的名字" + i);
            teacherService.addTeacher(teacher);
        }
    }

    @Test
    public void getStudentAndTeacher() {
        Map<String, Object> messageResponse = studentService.getTeacherById(1);
        System.out.println(messageResponse.toString());
    }
}

