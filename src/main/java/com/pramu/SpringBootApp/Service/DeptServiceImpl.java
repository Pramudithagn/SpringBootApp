package com.pramu.SpringBootApp.Service;

import com.pramu.SpringBootApp.Entity.Department;
import com.pramu.SpringBootApp.Repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Override
    public void deleteDeptById(Long deptId) {
        deptRepository.deleteById(deptId);
    }

    @Override
    public Department updateDept(Long deptId, Department dept) {
        Department fetchedDept = deptRepository.findById(deptId).get();

        if(Objects.nonNull(dept.getName()) && !"".equalsIgnoreCase(dept.getName())){
            fetchedDept.setName(dept.getName());
        }

        if(Objects.nonNull(dept.getCode()) && !"".equalsIgnoreCase(dept.getCode())){
            fetchedDept.setCode(dept.getCode());
        }

        if(Objects.nonNull(dept.getAddress()) && !"".equalsIgnoreCase(dept.getAddress())){
            fetchedDept.setAddress(dept.getAddress());
        }

        return deptRepository.save(fetchedDept);
    }

    @Override
    public Department getDeptByName(String deptName) {
        return deptRepository.findDepartmentByName(deptName);
    }

    @Override
    public Department getDeptByNameIgnoreCase(String deptName) {
        return deptRepository.findDepartmentByNameIgnoreCase(deptName);
    }


}
