package cn.exiafor.mapper;

import cn.exiafor.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    // 多对一赋值

    Emp getEmpAndDeptByEmpId(@Param("empId") int empId);
}
