package com.pramu.SpringBootApp.Service;

import com.pramu.SpringBootApp.Entity.Department;
import com.pramu.SpringBootApp.Repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public Department getDeptById(Long deptId) {
        return deptRepository.findById(deptId).get();
    }

    @Override
    public Department saveDept(Department dept) {
        return deptRepository.save(dept);
    }

    @Override
    public List<Department> getAllDept() {
        return deptRepository.findAll();
    }

}
