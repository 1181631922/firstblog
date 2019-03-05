package com.fanyafeng.firstblog.service;

import com.fanyafeng.firstblog.model.Teacher;
import com.fanyafeng.firstblog.returnmessage.MessageResponse;

/**
 * Author： fanyafeng
 * Data： 2019-03-04 20:52
 * Email: fanyafeng@live.cn
 */
public interface TeacherService {

    Teacher getTeacherById(int teacherId);

    boolean addTeacher(Teacher teacher);
}
