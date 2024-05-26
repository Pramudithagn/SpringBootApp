package com.pramu.SpringBootApp.Controller;

import com.pramu.SpringBootApp.Entity.Department;
import com.pramu.SpringBootApp.Error.DepartmentNotFoundException;
import com.pramu.SpringBootApp.Service.DeptService;
import com.pramu.SpringBootApp.Service.DeptServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    private final Logger LOGGER = LoggerFactory.getLogger(DeptController.class);

    @PostMapping("/department")
    public Department saveDept(@Valid @RequestBody Department dept){
        LOGGER.info("Saved dept with details");
        return deptService.saveDept(dept);
    };

    @GetMapping("/departments")
    public List<Department> getAllDept(){
        LOGGER.info("Got all depts");
        return deptService.getAllDept();
    }

    @GetMapping("/departments/{id}")
    public Department getDeptById(@PathVariable("id") Long deptId) throws DepartmentNotFoundException {
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
