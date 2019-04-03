package com.hyun.shopping_mall_example.service;

import com.hyun.shopping_mall_example.domain.GoodsCategoryVO;

import java.util.List;

public interface AdminService {
    public List<GoodsCategoryVO> getGoodsCategory() throws Exception;
}
