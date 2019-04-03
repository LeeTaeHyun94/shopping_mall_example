package com.hyun.shopping_mall_example.service;

import com.hyun.shopping_mall_example.domain.GoodsCategoryVO;
import com.hyun.shopping_mall_example.domain.GoodsVO;

import java.util.List;

public interface AdminService {
    public List<GoodsCategoryVO> getGoodsCategory() throws Exception;
    public void registerGoods(GoodsVO goodsVO) throws Exception;
    public List<GoodsVO> goodsList() throws Exception;
    public GoodsVO getGoods(Long id) throws Exception;
}
