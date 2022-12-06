package cn.exiafor.zhxy.service.impl;

import cn.exiafor.zhxy.mapper.StudentMapper;
import cn.exiafor.zhxy.pojo.Admin;
import cn.exiafor.zhxy.pojo.LoginForm;
import cn.exiafor.zhxy.pojo.Student;
import cn.exiafor.zhxy.service.StudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Override
    public Student login(LoginForm loginForm) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("name", loginForm.getUsername());
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));

        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public Student getStudentById(Long userId) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userId);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public IPage<Student> getStudentByOpr(Page<Student> pageParam, Student student) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();

        // 拼接查询条件
        if (!StringUtils.isEmpty(student.getName())) {
            queryWrapper.like("name", student.getName());
        }

        // 拼接查询条件
        if (!StringUtils.isEmpty(student.getClazzName())) {
            queryWrapper.like("clazz_name", student.getClazzName());
        }

        queryWrapper.orderByDesc("id");
        return baseMapper.selectPage(pageParam, queryWrapper);
    }
}
