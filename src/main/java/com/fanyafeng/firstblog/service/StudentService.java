package com.fanyafeng.firstblog.service;

import com.fanyafeng.firstblog.model.Student;
import com.fanyafeng.firstblog.model.Teacher;
import com.fanyafeng.firstblog.returnmessage.MessageResponse;

import java.util.List;
import java.util.Map;

/**
 * Author： fanyafeng
 * Data： 2019-03-04 20:52
 * Email: fanyafeng@live.cn
 */
public interface StudentService {
    Student getStudentInfoById(int studentId);

    /**
     * 通过id获取学生信息
     *
     * @param studentId
     * @return
     */
    Student getStudentById(int studentId);

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    boolean addStudent(Student student);

    /**
     * 更新学生信息
     *
     * @param student
     * @return
     */
    boolean updateByPrimaryKey(Student student);

    /**
     * 根据用户id删除用户
     *
     * @param studentId
     * @return
     */
    boolean deleteByPrimaryKey(int studentId);

    /**
     * 插入学生信息
     *
     * @param student
     * @return
     */
    boolean insert(Student student);

    /**
     * 模糊查询
     *
     * @param likeField
     * @return
     */
    List<Student> selectByLikeField(String likeField);

    /**
     * 按照字段排序
     *
     * @param orderByClause
     * @return
     */
    List<Student> selectOrderByClause(String orderByClause);

    /**
     * 可模糊可精确查询
     *
     * @param student
     * @return
     */
    List<Student> selectByCondition(Student student);

    /**
     * 通过学生id获取老师id从而获取老师信息
     *
     * @param studentId
     * @return
     */
    Map<String,Object> getTeacherById(int studentId);
}
