package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    
    private Integer Id;
    
    private String username;
    
    private String password;
}
