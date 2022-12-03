package cn.exiafor.zhxy.controller;

import cn.exiafor.zhxy.pojo.Admin;
import cn.exiafor.zhxy.pojo.LoginForm;
import cn.exiafor.zhxy.pojo.Student;
import cn.exiafor.zhxy.pojo.Teacher;
import cn.exiafor.zhxy.service.AdminService;
import cn.exiafor.zhxy.service.StudentService;
import cn.exiafor.zhxy.service.TeacherService;
import cn.exiafor.zhxy.util.CreateVerifiCodeImage;
import cn.exiafor.zhxy.util.JwtHelper;
import cn.exiafor.zhxy.util.MD5;
import cn.exiafor.zhxy.util.Result;
import cn.exiafor.zhxy.util.ResultCodeEnum;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Api(tags = "系统控制器")
@RestController
@RequestMapping("/sms/system")
public class SystemController {
    private final AdminService adminService;
    private final StudentService studentService;
    private final TeacherService teacherService;

    public SystemController(AdminService adminService, StudentService studentService, TeacherService teacherService) {
        this.adminService = adminService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @ApiOperation("更新用户密码的处理器")
    @PostMapping("/updatePwd/{oldPwd}/{newPwd}")
    public Result<Object> updatePwd(
            @ApiParam("旧密码") @PathVariable("oldPwd") String oldPwd,
            @ApiParam("新密码") @PathVariable("newPwd") String newPwd,
            @ApiParam("token口令") @RequestHeader("token") String token
    ) {
        boolean expiration = JwtHelper.isExpiration(token);

        if (expiration) {
            // token过期
            return Result.fail().message("token失效，请重新登录后修改密码");
        }

        // 获取用户id和用户类型
        Long userId = JwtHelper.getUserId(token);
        int userType = JwtHelper.getUserType(token);

        oldPwd = MD5.encrypt(oldPwd);
        newPwd = MD5.encrypt(newPwd);

        switch (userType) {
            case 1:
                QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
                adminQueryWrapper.eq("id", userId);
                adminQueryWrapper.eq("password", oldPwd);
                Admin admin = adminService.getOne(adminQueryWrapper);
                if (null != admin) {
                    admin.setPassword(newPwd);
                    adminService.saveOrUpdate(admin);
                } else {
                    return Result.fail().message("原密码有误！");
                }
                break;
            case 2:
                QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
                studentQueryWrapper.eq("id", userId);
                studentQueryWrapper.eq("password", oldPwd);
                Student student = studentService.getOne(studentQueryWrapper);
                if (null != student) {
                    student.setPassword(newPwd);
                    studentService.saveOrUpdate(student);
                } else {
                    return Result.fail().message("原密码有误！");
                }
                break;
            case 3:
                QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
                teacherQueryWrapper.eq("id", userId);
                teacherQueryWrapper.eq("password", oldPwd);
                Teacher teacher = teacherService.getOne(teacherQueryWrapper);
                if (null != teacher) {
                    teacher.setPassword(newPwd);
                    teacherService.saveOrUpdate(teacher);
                } else {
                    return Result.fail().message("原密码有误！");
                }
                break;
        }

        return Result.ok();
    }

    @ApiOperation("文件上传统一入口")
    @PostMapping("/headerImgUpload")
    public Result<Object> headerImgUpload(
            @ApiParam("头像文件") @RequestPart("multipartFile") MultipartFile multipartFile
    ) {
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        String originalFilename = multipartFile.getOriginalFilename();
        assert originalFilename != null;
        String newFileName = uuid + originalFilename.substring(originalFilename.lastIndexOf('.'));
        // 保存文件 将文件发送到第三方/独立的图片服务器上

//        String savePath = "D:\\d-dual-backup-to-e\\code\\exiafor-review\\" +
//                "zhxy\\target\\classes\\public\\upload\\" +
//                newFileName;

        String savePath = System.getProperty("user.dir") + "/target/classes/public/upload" +  File.separator + newFileName;

        try {
            multipartFile.transferTo(new File(savePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 响应图片的路径
        String path = "upload/" + newFileName;
        return Result.ok(path);
    }

    @ApiOperation("通过token口令获取当前登录的用户信息的方法")
    @GetMapping("/getInfo")
    public Result<Object> getInfoByToken(
            @ApiParam("token口令")
            @RequestHeader("token") String token
    ) {
        boolean expiration = JwtHelper.isExpiration(token);
        if (expiration) {
            return Result.build(null, ResultCodeEnum.TOKEN_ERROR);
        }
        // 从token中解析出，用户id和用户的类型
        Long userId = JwtHelper.getUserId(token);
        int userType = JwtHelper.getUserType(token);

        Map<String, Object> map = new HashMap<>();

        switch (userType) {
            case 1:
                Admin admin = adminService.getAdminById(userId);
                map.put("userType", 1);
                map.put("user", admin);
                break;
            case 2:
                Student student = studentService.getStudentById(userId);
                map.put("userType", 2);
                map.put("user", student);
                break;
            case 3:
                Teacher teacher = teacherService.getTeacherById(userId);
                map.put("userType", 3);
                map.put("user", teacher);
                break;
        }

        return Result.ok(map);
    }

    @ApiOperation("登录的方法")
    @PostMapping("/login")
    public Result<Object> login(
            @ApiParam("登录提交信息的form表单")
            @RequestBody LoginForm loginForm,
            HttpServletRequest request) {
        // 验证码教员
        HttpSession session = request.getSession();
        String sessionVerifiCode = (String) session.getAttribute("verifiCode");
        String loginVerifiCode = loginForm.getVerifiCode();

        if ("".equals(sessionVerifiCode) || null == sessionVerifiCode) {
            return Result.fail().message("验证码失效，请刷新后重试");
        }

        if (!sessionVerifiCode.equalsIgnoreCase(loginVerifiCode)) {
            return Result.fail().message("验证码输入错误，请重新输入");
        }

        // 从session域中移除现有验证码
        session.removeAttribute("verifiCode");

        // 分用户类型进行校验
        Map<String, Object> map = new HashMap<>();

        switch (loginForm.getUserType()) {
            case 1:
                try {
                    Admin admin = adminService.login(loginForm);
                    if (null != admin) {
                        map.put("token", JwtHelper.createToken(admin.getId().longValue(), 1));
                    } else {
                        throw new RuntimeException("用户名或密码有误");
                    }
                    return Result.ok(map);
                } catch (RuntimeException e) {
                    log.error("用户名或密码有误");
                    return Result.fail().message(e.getMessage());
                }
            case 2:
                try {
                    Student student = studentService.login(loginForm);
                    if (null != student) {
                        map.put("token", JwtHelper.createToken(student.getId().longValue(), 2));
                    } else {
                        throw new RuntimeException("用户名或密码有误");
                    }
                    return Result.ok(map);
                } catch (RuntimeException e) {
                    log.error("用户名或密码有误");
                    return Result.fail().message(e.getMessage());
                }
            case 3:
                try {
                    Teacher teacher = teacherService.login(loginForm);
                    if (null != teacher) {
                        map.put("token", JwtHelper.createToken(teacher.getId().longValue(), 3));
                    } else {
                        throw new RuntimeException("用户名或密码有误");
                    }
                    return Result.ok(map);
                } catch (RuntimeException e) {
                    log.error("用户名或密码有误");
                    return Result.fail().message(e.getMessage());
                }
        }

        return Result.fail().message("没有此用户");
    }

    @ApiOperation("获取验证码图片")
    @GetMapping("/getVerifiCodeImage")
    public void getVerifiCodeImage(HttpServletRequest request, HttpServletResponse response) {
        // 获取图片
        BufferedImage verifiCodeImage = CreateVerifiCodeImage.getVerifiCodeImage();
        // 获取图片上的验证码
        String verifiCode = new String(CreateVerifiCodeImage.getVerifiCode());
        // 将验证码文本放入session域，为下一次验证做准备
        HttpSession session = request.getSession();
        session.setAttribute("verifiCode", verifiCode);
        // 将验证码图片响应给浏览器
        try {
            ImageIO.write(verifiCodeImage, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
