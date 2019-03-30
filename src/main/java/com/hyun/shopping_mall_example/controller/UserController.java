package com.hyun.shopping_mall_example.controller;

import com.hyun.shopping_mall_example.domain.UserVO;
import com.hyun.shopping_mall_example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger Logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/signup")
    public void signup() throws Exception {
        Logger.info("Get Signup");
    }

    @PostMapping(value = "/signup")
    public String signup(UserVO userVO) throws Exception {
        Logger.info("Post Signup");
        userService.signup(userVO);
        return "redirect:/";
    }
}