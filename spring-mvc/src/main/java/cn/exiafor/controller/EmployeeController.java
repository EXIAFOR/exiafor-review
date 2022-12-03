package cn.exiafor.controller;

import cn.exiafor.dao.EmployeeDao;
import cn.exiafor.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class EmployeeController {
    @GetMapping(value = "/employee")
    public String getEmployeeList(Model model) {
        Collection<Employee> employeeList = EmployeeDao.getAll();
        model.addAttribute("employeeList", employeeList);
        return "employee_list";
    }

    @DeleteMapping(value = "/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        EmployeeDao.delete(id);
        return "redirect:/employee";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee) {
        EmployeeDao.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}")
    public String getEmployeeById(@PathVariable("id") Integer id, Model model) {
        Employee employee = EmployeeDao.get(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }

    @PutMapping("/employee")
    public String udpateEmployee(Employee employee){
        EmployeeDao.save(employee);
        return "redirect:/employee";
    }
}
