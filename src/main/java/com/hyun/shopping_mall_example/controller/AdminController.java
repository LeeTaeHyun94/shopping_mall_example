package com.hyun.shopping_mall_example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger Logger = LoggerFactory.getLogger(AdminController.class);

    @GetMapping(value = "/index")
    public void index() throws Exception {
        Logger.info("Get Index");
    }
}
