package com.pramu.SpringBootApp.Controller;

import com.pramu.SpringBootApp.Entity.Department;
import com.pramu.SpringBootApp.Service.DeptService;
import com.pramu.SpringBootApp.Service.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/department")
    public Department saveDept(@RequestBody Department dept){
        return deptService.saveDept(dept);
    };

    @GetMapping("/departments")
    public List<Department> getAllDept(){
        return deptService.getAllDept();
    }

    @GetMapping("/departments/{id}")
    public Department getDeptById(@PathVariable("id") Long deptId){
        return deptService.getDeptById(deptId);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDeptByName(@PathVariable("name") String deptName){
        return deptService.getDeptByName(deptName);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDeptById(@PathVariable("id") Long deptId){
        deptService.deleteDeptById(deptId);
        return "department deleted";
    }

    @PutMapping("/departments/{id}")
    public Department updateDept(@PathVariable("id") Long deptId, @RequestBody Department dept){
        return deptService.updateDept(deptId, dept);
    }

}
