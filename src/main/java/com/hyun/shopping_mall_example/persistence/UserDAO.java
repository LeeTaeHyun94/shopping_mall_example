package com.hyun.shopping_mall_example.persistence;

import com.hyun.shopping_mall_example.domain.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
    private SqlSession sqlSession;

    private static final String mapper = "com.hyun.shopping_mall_example.mapper.userMapper";

    public UserDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void signup(UserVO userVO) throws Exception {
        sqlSession.insert(mapper + ".signup", userVO);
    }

    public UserVO signin(UserVO userVO) throws Exception {
        return sqlSession.selectOne(mapper + ".signin", userVO);
    }
}
