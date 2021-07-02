package com.hwj.test.dao;

import com.hwj.test.bean.Employee;

public interface EmployeeDao {

    public Employee getEmpById(Integer id);
    public int updateEmployee(Employee employee);
    public boolean deleteEmployee(Integer id);
    public int insertEmployee(Employee employee);
}
