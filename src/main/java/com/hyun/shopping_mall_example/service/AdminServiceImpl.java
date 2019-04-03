package com.hyun.shopping_mall_example.service;

import com.hyun.shopping_mall_example.domain.GoodsCategoryVO;
import com.hyun.shopping_mall_example.domain.GoodsVO;
import com.hyun.shopping_mall_example.persistence.AdminDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO;

    public AdminServiceImpl(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Override
    public List<GoodsCategoryVO> getGoodsCategory() throws Exception {
        return adminDAO.getGoodsCategory();
    }

    @Override
    public void registerGoods(GoodsVO goodsVO) throws Exception {
        adminDAO.registerGoods(goodsVO);
    }
}
