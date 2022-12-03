package cn.exiafor.ssm.controller;

import cn.exiafor.ssm.pojo.Employee;
import cn.exiafor.ssm.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * 查询所有的员工信息 --> /employee --> get
 * 查询员工的分页信息 --> /employee/page/1 --> get
 * 跳转到添加页面 --> /to/add --> get
 * 添加员工信息 --> /employee --> post
 * 修改员工信息 --> /employee --> put
 * 删除员工信息 --> /employee --> delete
 */
@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/{empId}")
    public String toUpdate(
            @PathVariable("empId") int empId,
            Model model
    ) {
        Employee employee = employeeService.getEmployeeById(empId);
        // 将员工信息在请求域中共享
        model.addAttribute("employee", employee);
        // 跳转到employee_list.html
        return "employee_update";
    }

    @GetMapping("/employee")
    public String getAllEmployee(Model model) {
        // 查询所有的员工信息
        List<Employee> list = employeeService.getAllEmployee();
        // 将员工信息在请求域中共享
        model.addAttribute("list", list);
        // 跳转到employee_list.html
        return "employee_list";
    }

    @GetMapping("/employee/page/{pageNum}")
    public String getEmployeePage(
            @PathVariable("pageNum") Integer pageNum,
            Model model
    ) {
        // 获取员工的分页信息
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        // 将分页数据共享到请求域中
        model.addAttribute("page", page);

        // 跳转到employee_list.html
        return "employee_list";
    }

    @PostMapping("/employee")
    public String saveEmployee(
            Employee employee
    ){
        employeeService.saveEmployee(employee);
        return "redirect:/employee/page/1";
    }

    @DeleteMapping("/employee/{empId}")
    public String deleteEmployeeById(
            @PathVariable("empId") int empId
    ){
        employeeService.deleteEmployeeById(empId);
        return "redirect:/employee/page/1";
    }

    @PutMapping("/employee")
    public String updateEmployeeById(Employee employee){
        employeeService.updateEmployeeById(employee);
        return "redirect:/employee/page/1";
    }
}
