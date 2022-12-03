package cn.exiafor.zhxy.service;

import cn.exiafor.zhxy.pojo.Admin;
import cn.exiafor.zhxy.pojo.LoginForm;
import cn.exiafor.zhxy.pojo.Teacher;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface TeacherService extends IService<Teacher> {
    Teacher login(LoginForm loginForm);

    Teacher getTeacherById(Long userId);

    IPage<Teacher> getTeacherByOpr(Page<Teacher> pageParam, Teacher teacher);
}
