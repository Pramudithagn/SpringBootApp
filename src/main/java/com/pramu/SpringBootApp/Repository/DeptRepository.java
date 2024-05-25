package com.pramu.SpringBootApp.Repository;

import com.pramu.SpringBootApp.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Department, Long> {
    public Department findDepartmentByName(String deptName);

    public Department findDepartmentByNameIgnoreCase(String deptName);

}
