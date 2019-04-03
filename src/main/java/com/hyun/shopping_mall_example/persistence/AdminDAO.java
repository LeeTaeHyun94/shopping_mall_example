package com.hyun.shopping_mall_example.persistence;

import com.hyun.shopping_mall_example.domain.GoodsCategoryVO;
import com.hyun.shopping_mall_example.domain.GoodsVO;
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
}
