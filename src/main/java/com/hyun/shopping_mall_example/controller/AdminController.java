package com.hyun.shopping_mall_example.controller;

import com.hyun.shopping_mall_example.domain.GoodsCategoryVO;
import com.hyun.shopping_mall_example.domain.GoodsVO;
import com.hyun.shopping_mall_example.service.AdminService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public void registerGoods(Model model) throws Exception {
        System.out.println("Get Admin Goods Register");

        List<GoodsCategoryVO> goodsCategories = adminService.getGoodsCategory();
        model.addAttribute("goodsCategories", JSONArray.fromObject(goodsCategories));
    }

    @PostMapping(value = "/goods/register")
    public String registerGoods(GoodsVO goodsVO) throws Exception {
        adminService.registerGoods(goodsVO);
        return "redirect:/admin/index";
    }

    @GetMapping(value = "/goods/list")
    public void getGoodsList(Model model) throws Exception {
        System.out.println("Get Goods List");
        model.addAttribute("goodsList", adminService.goodsList());
    }

    @GetMapping(value = "/goods/detail")
    public void getGoods(@RequestParam("id") Long id, Model model) throws Exception {
        System.out.println("Get Goods");
        model.addAttribute("goods", adminService.getGoods(id));
    }
}
