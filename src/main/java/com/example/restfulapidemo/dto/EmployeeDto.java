package com.example.restfulapidemo.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "employees")
public class EmployeeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String firstname;

    private String lastname;

    private String email;

}
