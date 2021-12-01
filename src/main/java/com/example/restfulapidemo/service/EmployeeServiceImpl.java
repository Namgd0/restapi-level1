package com.example.restfulapidemo.service;

import com.example.restfulapidemo.dto.EmployeeDto;
import com.example.restfulapidemo.mapper.EmployeeMapper;
import com.example.restfulapidemo.model.Employee;
import com.example.restfulapidemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDto> getallEmployee() {
        return employeeMapper.modelstoDtos(employeeRepository.findAll());
    }

    @Override
    public Optional<EmployeeDto> findEmployeeById(Integer id) {
        return Optional.of(employeeMapper.modelToDto(employeeRepository.findById(id).get()));
    }

    @Override
    public Employee saveEmployee(EmployeeDto employeeDto) {
        return employeeRepository.save(employeeMapper.dtoToModel(employeeDto));
    }

    @Override
    public void removeEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

}
