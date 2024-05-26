package com.pramu.SpringBootApp.Service;

import com.pramu.SpringBootApp.Entity.Department;
import com.pramu.SpringBootApp.Repository.DeptRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeptServiceTest {

    @Autowired
    private DeptService deptService;

    @MockBean
    private DeptRepository mockDeptRepository;

    @BeforeEach
    void setUp() {
        Department dept = Department.builder().name("onedept").address("mockAd").code("mockCode").id(1L).build();
        Mockito.when(mockDeptRepository.findDepartmentByName("onedept")).thenReturn(dept);
    }

    @Test
    @DisplayName("Get the department when a valid name provided")
    public void getDeptByName_whenNameIsValidTest(){
        String deptName = "onedept";

        Department fetchedDept = deptService.getDeptByName(deptName);

        assertEquals(deptName, fetchedDept.getName());
    }
}