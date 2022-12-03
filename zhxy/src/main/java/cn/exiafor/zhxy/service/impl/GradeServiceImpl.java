package cn.exiafor.zhxy.service.impl;

import cn.exiafor.zhxy.mapper.GradeMapper;
import cn.exiafor.zhxy.pojo.Grade;
import cn.exiafor.zhxy.service.GradeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements GradeService {
    @Override
    public IPage<Grade> getGradeByOpr(Page<Grade> page, String gradeName) {
        QueryWrapper<Grade> queryWrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(gradeName)) {
            queryWrapper.like("name", gradeName);
        }

        queryWrapper.orderByDesc("id");

        return baseMapper.selectPage(page, queryWrapper);
    }

    @Override
    public List<Grade> getGrades() {
        // 没有queryWrapper，代表查询全部
        List<Grade> grades = baseMapper.selectList(null);
        return grades;
    }
}
