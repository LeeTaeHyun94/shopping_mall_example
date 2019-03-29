package com.hyun.shopping_mall_example.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class GoodsVO {
    private Long id;
    private String name;
    private Long categoryId;
    private int price;
    private int stock;
    private String description;
    private String imgUrl;
    private Timestamp regDate;
}
