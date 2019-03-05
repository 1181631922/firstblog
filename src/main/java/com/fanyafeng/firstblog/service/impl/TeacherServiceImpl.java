package com.fanyafeng.firstblog.service.impl;

import com.fanyafeng.firstblog.dao.TeacherMapper;
import com.fanyafeng.firstblog.model.Teacher;
import com.fanyafeng.firstblog.returnmessage.MessageResponse;
import com.fanyafeng.firstblog.service.TeacherService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author： fanyafeng
 * Data： 2019-03-04 21:40
 * Email: fanyafeng@live.cn
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper mapper;

    @Override
    public Teacher getTeacherById(int teacherId) {
        return mapper.selectByPrimaryKey(teacherId);
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        try {
            mapper.insertSelective(teacher);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
