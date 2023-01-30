package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

class EmployeesTest {

    EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl(List.of
            (new Employee("e1",5000),new Employee("e2",7000))); //Testdouble
    BankService bankService = Mockito.mock(BankService.class); // Mocking bankservice
    Employees employees = new Employees(employeeRepository,bankService);


    @Test
    void CheckingThatEmployeesGetPaid() {
        employees.payEmployees();



        assertTrue(employeeRepository.findAll().get(0).isPaid());


    }
    @Test
    void CheckingThatThePaymentsReturnsTheSameNumberOfEmployees() {

        assertEquals(2,employees.payEmployees());

    }
    @Test
    void TestingThatPayingEmployeeErrorResultInFalse() {
        doThrow(new RuntimeException()).when(bankService).pay("e1",5000);
        employees.payEmployees();

        assertFalse(employeeRepository.findAll().get(0).isPaid());


    }

}



