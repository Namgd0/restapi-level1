package com.example.restfulapidemo.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Employeenotfound.class)
    public ResponseEntity employeenotfound(Employeenotfound employeenotfound){
        return new ResponseEntity("không tìm thấy", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EmployeeAlreadyExist.class)
    public ResponseEntity employeealreadyexist(EmployeeAlreadyExist employeeAlreadyExist){
        return  new ResponseEntity("Đã tồn tại bản ghi", HttpStatus.CONFLICT);
    }
}
