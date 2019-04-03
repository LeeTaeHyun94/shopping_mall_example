package com.hyun.shopping_mall_example.controller;

import com.hyun.shopping_mall_example.domain.GoodsCategoryVO;
import com.hyun.shopping_mall_example.service.AdminService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(value = "/index")
    public void index() throws Exception {
        System.out.println("Get Admin Index");
    }

    @GetMapping(value = "/goods/register")
    public void goodsRegister(Model model) throws Exception {
        System.out.println("Get Admin Goods Register");

        List<GoodsCategoryVO> goodsCategories = adminService.getGoodsCategory();
        model.addAttribute("goodsCategories", JSONArray.fromObject(goodsCategories));
    }
}
