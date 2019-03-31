package com.hyun.shopping_mall_example.service;

import com.hyun.shopping_mall_example.domain.UserVO;
import com.hyun.shopping_mall_example.persistence.UserDAO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserDAO userDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDAO = userDAO;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void signup(UserVO userVO) throws Exception {
        userVO.setPassword(bCryptPasswordEncoder.encode(userVO.getPassword()));
        userDAO.signup(userVO);
    }

    @Override
    public UserVO signin(UserVO userVO) throws Exception {
        UserVO loginUser = userDAO.signin(userVO);
        if (loginUser == null) return null;
        boolean matchPassword = bCryptPasswordEncoder.matches(userVO.getPassword(), loginUser.getPassword());
        if (!matchPassword) return null;
        return loginUser;
    }
}
