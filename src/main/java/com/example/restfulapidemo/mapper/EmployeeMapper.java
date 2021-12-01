package com.example.restfulapidemo.mapper;

import com.example.restfulapidemo.dto.EmployeeDto;
import com.example.restfulapidemo.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto modelToDto(Employee employeeDto);

    Employee dtoToModel(EmployeeDto employeeDto);

    List<EmployeeDto> modelstoDtos(List<Employee> employees);
}
