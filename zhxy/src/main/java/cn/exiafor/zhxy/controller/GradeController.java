package cn.exiafor.zhxy.controller;

import cn.exiafor.zhxy.pojo.Grade;
import cn.exiafor.zhxy.service.GradeService;
import cn.exiafor.zhxy.util.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "年级控制器")
@RestController
@RequestMapping("/sms/gradeController")
public class GradeController {
    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @ApiOperation("获取全部年级")
    @GetMapping("/getGrades")
    public Result<Object> getGrades() {
        List<Grade> grades = gradeService.getGrades();
        return Result.ok(grades);
    }


    @ApiOperation("删除Grade信息")
    @DeleteMapping("/deleteGrade")
    public Result<Object> deleteGrade(
            @ApiParam("要删除的所有的grade的id的JSON集合")
            @RequestBody
            List<Integer> ids
    ) {
        gradeService.removeByIds(ids);
        return Result.ok();
    }

    @ApiOperation("新增或者修改Grade，有id属性是修改，没有则是增加")
    @PostMapping("/saveOrUpdateGrade")
    public Result<Object> saveOrUpdateGrade(
            @ApiParam("JSON的Grade对象")
            @RequestBody
            Grade grade
    ) {
        // 接受参数
        gradeService.saveOrUpdate(grade);

        // 调用服务层方法完成增加或者修改
        return Result.ok();
    }

    @ApiOperation("根据年级名称模糊查询，带分页")
    @GetMapping("/getGrades/{pageNo}/{pageSize}")
    public Result<Object> getGrades(
            @ApiParam("分页查询的页码数") @PathVariable("pageNo") Integer pageNo,
            @ApiParam("分页查询的页码大小") @PathVariable("pageSize") Integer pageSize,
            @ApiParam("分页查询模糊匹配的名称") @RequestParam(required = false) String gradeName
    ) {
        // 分页 带条件查询
        Page<Grade> page = new Page<>(pageNo, pageSize);
        // 通过服务层完成
        IPage<Grade> pageResult = gradeService.getGradeByOpr(page, gradeName);

        // 封装Result对象并返回
        return Result.ok(pageResult);
    }
}
