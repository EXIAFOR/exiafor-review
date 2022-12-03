package cn.exiafor.ssm.service.impl;

import cn.exiafor.ssm.mapper.EmployeeMapper;
import cn.exiafor.ssm.pojo.Employee;
import cn.exiafor.ssm.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Employee> getEmployeePage(int pageNum) {
        // 开启分页功能
        PageHelper.startPage(pageNum, 4);
        // 查询所有的员工信息
        List<Employee> list = employeeMapper.getAllEmployee();
        // 获取分页相关数据
        return new PageInfo<>(list, 5);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeMapper.saveEmployee(employee);
    }

    @Override
    public void deleteEmployeeById(int empId) {
        employeeMapper.deleteEmployeeById(empId);
    }

    @Override
    public Employee getEmployeeById(int empId) {
        return employeeMapper.getEmployeeById(empId);
    }

    @Override
    public void updateEmployeeById(Employee employee) {
        employeeMapper.updateEmployeeById(employee);
    }
}
