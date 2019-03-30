package com.hyun.shopping_mall_example.service;

import com.hyun.shopping_mall_example.domain.UserVO;
import com.hyun.shopping_mall_example.persistence.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void signup(UserVO userVO) throws Exception {
        userDAO.signup(userVO);
    }
}
