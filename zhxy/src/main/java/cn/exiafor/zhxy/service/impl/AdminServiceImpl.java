package cn.exiafor.zhxy.service.impl;

import cn.exiafor.zhxy.mapper.AdminMapper;
import cn.exiafor.zhxy.pojo.Admin;
import cn.exiafor.zhxy.pojo.LoginForm;
import cn.exiafor.zhxy.service.AdminService;
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
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Override
    public Admin login(LoginForm loginForm) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("name", loginForm.getUsername());
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));

        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public Admin getAdminById(Long userId) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userId);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public IPage<Admin> getAdminByOpr(Page<Admin> pageParam, String adminName) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(adminName)) {
            queryWrapper.like("name", adminName);
        }

        queryWrapper.orderByDesc("id");

        return baseMapper.selectPage(pageParam, queryWrapper);
    }
}
