package com.hyun.shopping_mall_example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping(value = "/index")
    public void index() throws Exception {
        System.out.println("Get Admin Index");
    }
}
