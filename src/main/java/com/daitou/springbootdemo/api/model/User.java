package com.daitou.springbootdemo.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {


    private static final long serialVersionUID = 1672107717649158390L;
    private String id;
    private String userName;
    private String passWord;

}
