package com.pramu.SpringBootApp.Service;

import com.pramu.SpringBootApp.Entity.Department;

import java.util.List;

public interface DeptService {
    public Department getDeptById(Long deptId);

    public Department saveDept(Department dept);

    public List<Department> getAllDept();
}

