package com.pramu.SpringBootApp.Controller;

import com.pramu.SpringBootApp.Entity.Department;
import com.pramu.SpringBootApp.Error.DepartmentNotFoundException;
import com.pramu.SpringBootApp.Service.DeptService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DeptController.class)
class DeptControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeptService deptService;

    private Department dept;

    @BeforeEach
    void setUp() {
         dept = Department.builder().name("onedept").address("mockAd").code("mockCode").id(1L).build();    }

    @Test
    void saveDept() throws Exception {
        Department inputDept = Department.builder().name("onedept").address("mockAd").code("mockCode").build();

        Mockito.when(deptService.saveDept(inputDept)).thenReturn(dept);

        mockMvc.perform(MockMvcRequestBuilders.post("/department").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\":\"onedept\",\n" +
                        "    \"code\":\"mockCode\",\n" +
                        "    \"address\":\"mockAd\"\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void getDeptById() throws Exception {
        Mockito.when(deptService.getDeptById(1L)).thenReturn(dept);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(dept.getName()));
    }
}