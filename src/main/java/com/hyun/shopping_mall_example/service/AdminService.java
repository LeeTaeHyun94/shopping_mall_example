package com.hyun.shopping_mall_example.service;

import com.hyun.shopping_mall_example.domain.GoodsCategoryVO;
import com.hyun.shopping_mall_example.domain.GoodsVO;
import com.hyun.shopping_mall_example.dto.GoodsDetailDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AdminService {
    public List<GoodsCategoryVO> getGoodsCategory() throws Exception;
    public void registerGoods(GoodsVO goodsVO, MultipartFile imgFile) throws Exception;
    public List<GoodsVO> goodsList() throws Exception;
    public GoodsVO getGoods(Long id) throws Exception;
    public GoodsDetailDTO goodsDetail(Long id) throws Exception;
    public void modifyGoods(GoodsVO goodsVO) throws Exception;
    public void deleteGoods(Long id) throws Exception;
}
