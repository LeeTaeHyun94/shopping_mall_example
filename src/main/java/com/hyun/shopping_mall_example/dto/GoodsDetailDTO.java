package com.hyun.shopping_mall_example.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class GoodsDetailDTO {
    private Long id;
    private String name;
    private Long categoryId;
    private int price;
    private int stock;
    private String description;
    private String imgUrl;
    private Timestamp reg_date;

    private Long categoryIdRef;
    private String firstCategoryName;
    private String secondCategoryName;
}
