package com.hyun.shopping_mall_example.controller;

import com.hyun.shopping_mall_example.domain.UserVO;
import com.hyun.shopping_mall_example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @GetMapping(value = "/signin")
    public void signin() throws Exception {
        Logger.info("Get Signin");
    }

    @PostMapping(value = "/signin")
    public String signin(UserVO userVO, HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes) throws Exception {
        UserVO loginUser = userService.signin(userVO);
        HttpSession httpSession = httpServletRequest.getSession();
        if (loginUser == null) {
            httpSession.setAttribute("user", null);
            redirectAttributes.addFlashAttribute("msg", false);
            return "redirect:/user/signin";
        }
        httpSession.setAttribute("user", loginUser);
        return "redirect:/";
    }

    @GetMapping(value = "/signout")
    public String signout(HttpSession httpSession) throws Exception {
        Logger.info("Get Signout");
        httpSession.invalidate();
        return "redirect:/";
    }
}