package com.example.restfulapidemo.controller;

import com.example.restfulapidemo.dto.EmployeeDto;
import com.example.restfulapidemo.exeption.EmployeeAlreadyExist;
import com.example.restfulapidemo.exeption.Employeenotfound;
import com.example.restfulapidemo.mapper.EmployeeMapper;
import com.example.restfulapidemo.model.Employee;
import com.example.restfulapidemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    private EmployeeMapper employeeMapper;

    // Lấy danh sách tất cả id trong database
    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getallEmployee() {
        return new ResponseEntity<>(employeeService.getallEmployee(), HttpStatus.OK);
    }

    // Lấy môt id bất kỳ trong danh sách id trong database
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
        Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);
        if(employeeOptional.isEmpty()){
            throw new Employeenotfound("không tìm thấy");
        }
        return employeeOptional.map(employeeDto -> new ResponseEntity<>(employeeDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Thêm một id vào danh sách trong database
    @PostMapping()
    public ResponseEntity<EmployeeDto> createNewEmployee(@RequestBody EmployeeDto employeeDto) {employeeService.saveEmployee(employeeDto);
        Employee employeeOptional = employeeService.findEmployeeByName(employeeDto.getFirstname());
        if (employeeOptional != null){
            throw new EmployeeAlreadyExist("Đã tồn tại bản ghi");
        }
        employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//     Cập nhật một id có sẵn trong database
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto) {
        Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);
        return employeeOptional.map(employeeDto1 -> {
            employeeDto.setId(employeeDto1.getId());
            return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // Xóa một id có sẵn trong danh sách
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id) {
        Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);
        return employeeOptional.map(employeeDto -> {
            employeeService.removeEmployee(id);
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
