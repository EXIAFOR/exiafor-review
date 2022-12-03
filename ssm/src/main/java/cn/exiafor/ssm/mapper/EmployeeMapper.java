package cn.exiafor.ssm.mapper;

import cn.exiafor.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    /**
     * 查询所有的员工信息
     */
    List<Employee> getAllEmployee();

    void saveEmployee(Employee employee);

    void deleteEmployeeById(int empId);

    Employee getEmployeeById(int empId);

    void updateEmployeeById(Employee employee);
}
