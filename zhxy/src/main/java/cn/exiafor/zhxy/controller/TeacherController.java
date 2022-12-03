package cn.exiafor.zhxy.controller;

import cn.exiafor.zhxy.pojo.Teacher;
import cn.exiafor.zhxy.service.TeacherService;
import cn.exiafor.zhxy.util.MD5;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "教师控制器")
@RestController
@RequestMapping("/sms/teacherController")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @ApiOperation("分页带条件查询教师信息")
    @GetMapping("/getTeachers/{pageNo}/{pageSize}")
    public Result<Object> getTeachers(
            @ApiParam("页码数") @PathVariable("pageNo") Integer pageNo,
            @ApiParam("页码大小") @PathVariable("pageSize") Integer pageSize,
            @ApiParam("管理员名字") Teacher teacher
    ) {
        Page<Teacher> pageParam = new Page<>(pageNo, pageSize);
        IPage<Teacher> teacherPage = teacherService.getTeacherByOpr(pageParam, teacher);
        return Result.ok(teacherPage);
    }


    // POST
    // saveOrUpdateTeacher
    @ApiOperation("增加或者修改教师信息")
    @PostMapping("/saveOrUpdateTeacher")
    public Result<Object> saveOrUpdateTeacher(
            @ApiParam("json格式的teacher对象") @RequestBody Teacher teacher
    ) {
        // 新增的需要加密密码
        Integer id = teacher.getId();
        if (null == id || 0 == id) {
            teacher.setPassword(MD5.encrypt(teacher.getPassword()));
        }
        teacherService.saveOrUpdate(teacher);
        return Result.ok();
    }


    // DELETE
    // deleteTeacher

    @ApiOperation("删除单个或者多个教师信息")
    @DeleteMapping("/deleteTeacher")
    public Result<Object> deleteTeacher(
            @RequestBody List<Integer> ids
    ) {
        teacherService.removeByIds(ids);
        return Result.ok();
    }
}
