package cn.exiafor.zhxy.controller;

import cn.exiafor.zhxy.pojo.Clazz;
import cn.exiafor.zhxy.service.ClazzService;
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

@Api(tags = "班级控制器")
@RestController
@RequestMapping("/sms/clazzController")
public class ClazzController {
    private final ClazzService clazzService;

    public ClazzController(ClazzService clazzService) {
        this.clazzService = clazzService;
    }

    @ApiOperation("查询所有班级的信息")
    @GetMapping("/getClazzs")
    public Result<Object> getClazzs() {
        List<Clazz> clazzes = clazzService.getClazzs();
        return Result.ok(clazzes);
    }

    @ApiOperation("删除单个和多个班级")
    @DeleteMapping("/deleteClazz")
    public Result<Object> deleteClazz(
            @ApiParam("请求删除班级的json-id数组")
            @RequestBody List<Integer> ids
    ) {
        clazzService.removeByIds(ids);
        return Result.ok();
    }

    @ApiOperation("添加或者修改班级")
    @PostMapping("/saveOrUpdateClazz")
    public Result<Object> saveOrUpdateClazz(
            // 请求载荷是json字符串，所以需要RequestBody注解
            @ApiParam("json格式的班级信息")
            @RequestBody Clazz clazz
    ) {
        clazzService.saveOrUpdate(clazz);
        return Result.ok();
    }

    // sms/clazzController/getClazzsByOpr/1/3
    // ?gradeName=%E4%BA%8C%E5%B9%B4%E7%BA%A7&name=6467
    @ApiOperation("分页带条件查询班级信息")
    @GetMapping("/getClazzsByOpr/{pageNo}/{pageSize}")
    public Result<Object> getClazzsByOpr(
            @ApiParam("分页查询的页码数") @PathVariable("pageNo") Integer pageNo,
            @ApiParam("分页查询的页大小") @PathVariable("pageSize") Integer pageSize,
            @ApiParam("分页查询的查询条件") Clazz clazz
    ) {
        Page<Clazz> page = new Page<>(pageNo, pageSize);
        IPage<Clazz> iPage = clazzService.getClazzsByOpr(page, clazz);
        return Result.ok(iPage);
    }
}
