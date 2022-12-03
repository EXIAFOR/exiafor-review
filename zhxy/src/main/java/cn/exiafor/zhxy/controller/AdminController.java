package cn.exiafor.zhxy.controller;

import cn.exiafor.zhxy.pojo.Admin;
import cn.exiafor.zhxy.service.AdminService;
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

@Api(tags = "管理员控制器")
@RestController
@RequestMapping("/sms/adminController")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
//    Request URL: http://192.168.2.200:8888/sms/adminController
//    /getAllAdmin/1/3?adminName=a
//    Request Method: GET

    @ApiOperation("分页带条件查询管理员信息")
    @GetMapping("/getAllAdmin/{pageNo}/{pageSize}")
    public Result<Object> getAllAdmin(
            @ApiParam("页码数") @PathVariable("pageNo") Integer pageNo,
            @ApiParam("页码大小") @PathVariable("pageSize") Integer pageSize,
            @ApiParam("管理员名字") String adminName
    ) {
        Page<Admin> pageParam = new Page<>(pageNo, pageSize);
        IPage<Admin> adminPage = adminService.getAdminByOpr(pageParam, adminName);
        return Result.ok(adminPage);
    }


    // POST
    // saveOrUpdateAdmin
    @ApiOperation("增加或者修改管理员信息")
    @PostMapping("/saveOrUpdateAdmin")
    public Result<Object> saveOrUpdateAdmin(
            @ApiParam("json格式的admin对象") @RequestBody Admin admin
    ) {
        // 新增的需要加密密码
        Integer id = admin.getId();
        if (null == id || 0 == id) {
            admin.setPassword(MD5.encrypt(admin.getPassword()));
        }
        adminService.saveOrUpdate(admin);
        return Result.ok();
    }


    // DELETE
    // deleteAdmin

    @ApiOperation("删除单个或者多个管理员信息")
    @DeleteMapping("/deleteAdmin")
    public Result<Object> deleteAdmin(
            @RequestBody List<Integer> ids
    ) {
        adminService.removeByIds(ids);
        return Result.ok();
    }
}
