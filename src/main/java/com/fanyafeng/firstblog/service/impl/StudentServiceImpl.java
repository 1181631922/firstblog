package com.fanyafeng.firstblog.service.impl;

import com.fanyafeng.firstblog.dao.StudentMapper;
import com.fanyafeng.firstblog.dao.TeacherMapper;
import com.fanyafeng.firstblog.model.Student;
import com.fanyafeng.firstblog.model.StudentExample;
import com.fanyafeng.firstblog.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author： fanyafeng
 * Data： 2019-03-04 20:53
 * Email: fanyafeng@live.cn
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper mapper;

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public Student getStudentInfoById(int studentId) {
        return mapper.selectByPrimaryKey(studentId);
    }

    /**
     * 通过id获取学生信息
     *
     * @param studentId
     * @return
     */
    @Override
    public Student getStudentById(int studentId) {
        return mapper.selectByPrimaryKey(studentId);
    }

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    @Override
    public boolean addStudent(Student student) {
        try {
            mapper.insertSelective(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 更新学生信息
     *
     * @param student
     * @return
     */
    @Override
    public boolean updateByPrimaryKey(Student student) {
        try {
            mapper.updateByPrimaryKey(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据用户id删除用户
     *
     * @param studentId
     * @return
     */
    @Override
    public boolean deleteByPrimaryKey(int studentId) {
        try {
            mapper.deleteByPrimaryKey(studentId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 插入学生信息
     *
     * @param student
     * @return
     */
    @Override
    public boolean insert(Student student) {
        try {
            mapper.insert(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 模糊查询
     *
     * @param likeField
     * @return
     */
    @Override
    public List<Student> selectByLikeField(String likeField) {
        StudentExample example = new StudentExample();
        example.createCriteria().andNameLike('%' + likeField + '%');
        return mapper.selectByExample(example);
    }

    /**
     * 按照字段排序
     *
     * @param orderByClause
     * @return
     */
    @Override
    public List<Student> selectOrderByClause(String orderByClause) {
        StudentExample example = new StudentExample();
        example.setOrderByClause(orderByClause);
        return mapper.selectByExample(example);
    }

    /**
     * 可模糊可精确查询
     *
     * @param student
     * @return
     */
    @Override
    public List<Student> selectByCondition(Student student) {
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(student.getName())) {
            criteria.andNameEqualTo(student.getName());
        }
        if (!StringUtils.isEmpty(student.getCourse())) {
            criteria.andCourseLike('%' + student.getCourse() + '%');
        }
        return mapper.selectByExample(example);
    }

    /**
     * 通过学生id获取老师id从而获取老师信息
     *
     * @param studentId
     * @return
     */
    @Override
    public Map<String, Object> getTeacherById(int studentId) {
        Map<String, Object> result = new HashMap<>();
        Student student = getStudentInfoById(studentId);
        result.put("student", student);
        result.put("teacher", teacherMapper.selectByPrimaryKey(student.getIdTeacher()));
        return result;
    }
}
