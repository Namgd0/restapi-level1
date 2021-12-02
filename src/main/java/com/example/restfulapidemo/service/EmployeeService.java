package com.example.restfulapidemo.service;

import com.example.restfulapidemo.dto.EmployeeDto;
import com.example.restfulapidemo.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeDto> getallEmployee();

    Optional<Employee> findEmployeeById(Integer id);

    Employee saveEmployee(EmployeeDto employeeDto);

    void removeEmployee(Integer id);

    Employee findEmployeeByName(String firstname);

}
