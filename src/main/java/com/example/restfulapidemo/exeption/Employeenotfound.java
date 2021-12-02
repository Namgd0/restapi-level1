package com.example.restfulapidemo.exeption;

public class Employeenotfound extends RuntimeException {
    private String message;

    public Employeenotfound(String message){
        super(message);
        this.message = message;
    }

    public Employeenotfound(){
    }
}
