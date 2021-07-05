package com.hwj.dao;

import com.hwj.bean.Employee;

public interface EmployeeDao {

    public Employee getEmpById(Integer id);
    public int updateEmployee(Employee employee);
    public boolean deleteEmployee(Integer id);
    public int insertEmployee(Employee employee);
}
