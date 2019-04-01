package com.hyun.shopping_mall_example.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class UserVO {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone_number;
    private String address;
    private String detail_address;
    private String zipcode;
    private Timestamp reg_date;
    private Boolean is_admin;
}
