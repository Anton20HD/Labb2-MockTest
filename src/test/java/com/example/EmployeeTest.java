package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee employee = new Employee("7800",8000.0);

    @Test
    void TestingEmployeeConstructor() {


        String id = "7800";
        double salary = 8000.0;
        boolean paid = false;

        assertEquals(id,employee.getId());
        assertEquals(salary,employee.getSalary());
        assertEquals(paid,employee.isPaid());



    }

    @Test
    void TestingEmployeeSettersAndGetters() {



        employee.setId("4565");
        employee.setSalary(60000.0);
        employee.setPaid(true);
        assertEquals("4565", employee.getId());
        assertEquals(60000.0, employee.getSalary());
        assertTrue(employee.isPaid());


    }

    @Test
    void TestingEmployeeToString() {


        System.out.println(employee);
        String answer = "Employee [id=" + "7800" + ", salary=" + 8000.0 + "]";

        assertEquals(answer,employee.toString());


    }



}






