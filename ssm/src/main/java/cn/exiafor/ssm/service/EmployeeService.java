package cn.exiafor.ssm.service;

import cn.exiafor.ssm.pojo.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeService {
    /**
     * 查询所有的员工信息
     */
    List<Employee> getAllEmployee();

    /**
     * 获取员工的分页信息
     */
    PageInfo<Employee> getEmployeePage(int pageNum);

    /**
     * 保存一个新的员工信息
     */
    void saveEmployee(Employee employee);

    /**
     * 根据id值删除员工信息
     * @param empId 员工id值
     */
    void deleteEmployeeById(int empId);

    /**
     * 根据员工id查询员工信息
     * @param empId 员工id
     * @return 员工对象
     */
    Employee getEmployeeById(int empId);

    /**
     * 根据员工对象修改员工信息
     * @param employee 员工对象
     */
    void updateEmployeeById(Employee employee);
}
