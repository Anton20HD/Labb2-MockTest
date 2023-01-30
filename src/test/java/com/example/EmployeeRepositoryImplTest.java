package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryImplTest {


    EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl(List.of
            (new Employee("e1",7000),new Employee("e2",8000)));


    @Test
    void TestingToFindTheCorrectNumberOfEmployeesInList() {

        assertEquals(2,employeeRepository.findAll().size());

    }
    @Test
    void TestingTheSaveMethod() {

        Employee employee1 = new Employee("e3",70000);
        Employee employee2 = new Employee("e4",90000);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        assertEquals(employee1,employeeRepository.findAll().get(2));
        assertEquals(employee2,employeeRepository.findAll().get(3));

    }

}



