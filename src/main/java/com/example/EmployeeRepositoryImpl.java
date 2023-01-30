package com.example;

import com.example.Employee;
import com.example.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    List<Employee> employeeList = new ArrayList<>();

    public EmployeeRepositoryImpl(List<Employee> addList) {

        this.employeeList.addAll(addList);
    }

    @Override
    public List<Employee> findAll() {
        return employeeList;
    }

    @Override
    public Employee save(Employee e) {
        employeeList.add(e);
        return e;

    }

}
