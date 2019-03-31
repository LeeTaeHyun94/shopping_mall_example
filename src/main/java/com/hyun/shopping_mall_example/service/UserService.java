package com.hyun.shopping_mall_example.service;

import com.hyun.shopping_mall_example.domain.UserVO;

import javax.servlet.http.HttpSession;

public interface UserService {
    public void signup(UserVO userVO) throws Exception;
    public UserVO signin(UserVO userVO) throws Exception;
    public void signout(HttpSession session) throws Exception;
}
