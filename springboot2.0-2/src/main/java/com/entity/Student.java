package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = -1624939251901259631L;
    private Integer Id;
    
    private String username;
    
    private String password;
}
