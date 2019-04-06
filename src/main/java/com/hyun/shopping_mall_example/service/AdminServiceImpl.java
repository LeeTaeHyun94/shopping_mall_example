package com.hyun.shopping_mall_example.service;

import com.hyun.shopping_mall_example.domain.GoodsCategoryVO;
import com.hyun.shopping_mall_example.domain.GoodsVO;
import com.hyun.shopping_mall_example.dto.GoodsDetailDTO;
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

    @Override
    public List<GoodsVO> goodsList() throws Exception {
        return adminDAO.goodsList();
    }

    @Override
    public GoodsVO getGoods(Long id) throws Exception {
        return adminDAO.getOneGoods(id);
    }

    @Override
    public GoodsDetailDTO goodsDetail(Long id) throws Exception {
        GoodsDetailDTO goods = adminDAO.goodsDetail(id);
        Long firstCategoryId = goods.getCategoryIdRef();
        if (firstCategoryId != null) goods.setFirstCategoryName(adminDAO.getGoodsCategoryName(firstCategoryId));
        else goods.setCategoryIdRef(0L);
        return goods;
    }

    @Override
    public void modifyGoods(GoodsVO goodsVO) throws Exception {
        adminDAO.modifyGoods(goodsVO);
    }

    @Override
    public void deleteGoods(Long id) throws Exception {
        adminDAO.deleteGoods(id);
    }
}
