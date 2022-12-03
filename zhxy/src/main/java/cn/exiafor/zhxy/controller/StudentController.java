package cn.exiafor.zhxy.controller;

import cn.exiafor.zhxy.pojo.Student;
import cn.exiafor.zhxy.service.StudentService;
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

@Api(tags = "学生控制器")
@RestController
@RequestMapping("/sms/studentController")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ApiOperation("删除单个或者多个学生信息")
    @DeleteMapping("/delStudentById")
    public Result<Object> delStudentById(
            @RequestBody List<Integer> ids
    ) {
        studentService.removeByIds(ids);
        return Result.ok();
    }

    @ApiOperation("增加或者修改学生信息")
    @PostMapping("/addOrUpdateStudent")
    public Result<Object> addOrUpdateStudent(
            @ApiParam("要保存或者修改的JSON信息") @RequestBody Student student
    ) {
        // 判断是否需要将密码转为密文
        Integer id = student.getId();
        // 新增学生信息，需要转为密文
        if (null == id || 0 == id) {
            student.setPassword(MD5.encrypt(student.getPassword()));
        }

        studentService.saveOrUpdate(student);
        return Result.ok();
    }

    // GET
    // sms/studentController/getStudentByOpr/1/3
    // ?name=&clazzName=
    @ApiOperation("分页带条件查询学生信息")
    @GetMapping("/getStudentByOpr/{pageNo}/{pageSize}")
    public Result<Object> getStudentByOpr(
            @ApiParam("页码数") @PathVariable("pageNo") Integer pageNo,
            @ApiParam("页码大小") @PathVariable("pageSize") Integer pageSize,
            @ApiParam("查询条件") Student student
    ) {
        Page<Student> pageParam = new Page<>(pageNo, pageSize);
        IPage<Student> studentPage = studentService.getStudentByOpr(pageParam, student);
        return Result.ok(studentPage);
    }
}
