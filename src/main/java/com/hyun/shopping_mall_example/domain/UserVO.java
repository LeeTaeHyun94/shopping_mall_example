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
    private String phoneNumber;
    private String address;
    private String detailAddress;
    private String zipcode;
    private Timestamp regDate;
    private Integer isEmailVerified;
}
