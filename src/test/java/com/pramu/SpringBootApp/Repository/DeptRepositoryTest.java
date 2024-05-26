package com.pramu.SpringBootApp.Repository;

import com.pramu.SpringBootApp.Entity.Department;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DeptRepositoryTest {

    @Autowired
    private DeptRepository deptRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department dept = Department.builder().name("mockData").address("mockAddress").code("mockCode").build();
        entityManager.persist(dept);
    }

    @Test
    public void getDeptByName_whenNameIsValidTest(){
        Department dept = deptRepository.findById(1L).get();
        assertEquals("mockData", dept.getName());
    }
}