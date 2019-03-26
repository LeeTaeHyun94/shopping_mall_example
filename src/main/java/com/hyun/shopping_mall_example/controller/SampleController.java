package com.hyun.shopping_mall_example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
    @RequestMapping("/view/{viewName}")
    public String view(@PathVariable("viewName") String viewName) {
        return viewName;
    }

    @RequestMapping("/value/{value}")
    @ResponseBody
    public String value(@PathVariable("value") String value) {
        return value;
    }
}
