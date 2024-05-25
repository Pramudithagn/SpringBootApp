package com.pramu.SpringBootApp.Service;

import com.pramu.SpringBootApp.Entity.Department;

import java.util.List;

public interface DeptService {
    public Department getDeptById(Long deptId);

    public Department saveDept(Department dept);

    public List<Department> getAllDept();

    public void deleteDeptById(Long deptId);

    public Department updateDept(Long deptId, Department dept);

    public Department getDeptByName(String deptName);

    public Department getDeptByNameIgnoreCase(String deptName);
}

