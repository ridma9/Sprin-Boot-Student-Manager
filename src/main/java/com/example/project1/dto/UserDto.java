package com.example.project1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private int userId;
    private String firstName;
    private String userAddress;
    private String lastName;
    private int age;
    private int grade;
    private String stream;
}
