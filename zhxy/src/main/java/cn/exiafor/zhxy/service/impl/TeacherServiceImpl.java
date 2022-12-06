package cn.exiafor.zhxy.service.impl;

import cn.exiafor.zhxy.mapper.TeacherMapper;
import cn.exiafor.zhxy.pojo.Admin;
import cn.exiafor.zhxy.pojo.LoginForm;
import cn.exiafor.zhxy.pojo.Student;
import cn.exiafor.zhxy.pojo.Teacher;
import cn.exiafor.zhxy.service.TeacherService;
import cn.exiafor.zhxy.util.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Override
    public Teacher login(LoginForm loginForm) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("name", loginForm.getUsername());
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));

        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public Teacher getTeacherById(Long userId) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userId);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public IPage<Teacher> getTeacherByOpr(Page<Teacher> pageParam, Teacher teacher) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();

        // 拼接查询条件
        if (!StringUtils.isEmpty(teacher.getName())) {
            queryWrapper.like("name", teacher.getName());
        }

        // 拼接查询条件
        if (!StringUtils.isEmpty(teacher.getClazzName())) {
            queryWrapper.like("clazz_name", teacher.getClazzName());
        }

        queryWrapper.orderByDesc("id");
        return baseMapper.selectPage(pageParam, queryWrapper);
    }
}
