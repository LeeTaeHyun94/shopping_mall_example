package com.hyun.shopping_mall_example.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsCategoryVO {
    private Long id;
    private String name;
    private Long categoryIdRef;
}
