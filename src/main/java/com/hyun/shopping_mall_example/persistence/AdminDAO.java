package com.hyun.shopping_mall_example.persistence;

import com.hyun.shopping_mall_example.domain.GoodsCategoryVO;
import com.hyun.shopping_mall_example.domain.GoodsVO;
import com.hyun.shopping_mall_example.dto.GoodsDetailDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminDAO {
    private SqlSession sqlSession;

    private static final String mapper = "com.hyun.shopping_mall_example.mapper.adminMapper";

    public AdminDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<GoodsCategoryVO> getGoodsCategory() throws Exception {
        return sqlSession.selectList(mapper + ".goodsCategory");
    }

    public void registerGoods(GoodsVO goodsVO) throws Exception {
        sqlSession.insert(mapper + ".registerGoods", goodsVO);
    }

    public List<GoodsVO> goodsList() throws Exception {
        return sqlSession.selectList(mapper + ".goodsList");
    }

    public GoodsVO getOneGoods(Long id) throws Exception {
        return sqlSession.selectOne(mapper + ".oneGoods", id);
    }

    public GoodsDetailDTO goodsDetail(Long id) throws Exception {
        return sqlSession.selectOne(mapper + ".goodsDetail", id);
    }

    public String getGoodsCategoryName(Long id) throws Exception {
        return sqlSession.selectOne(mapper + ".getGoodsCategoryName", id);
    }

    public void modifyGoods(GoodsVO goodsVO) throws Exception {
        sqlSession.update(mapper + ".modifyGoods", goodsVO);
    }

    public void deleteGoods(Long id) throws Exception {
        sqlSession.delete(mapper + ".deleteGoods", id);
    }
}
