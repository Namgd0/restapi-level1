package com.example.restfulapidemo.exeption;

public class EmployeeAlreadyExist extends RuntimeException {
    private String message;

    public EmployeeAlreadyExist(String message){
        super(message);
        this.message = message;
    }

    public EmployeeAlreadyExist(){
    }
}
