package com.hyun.shopping_mall_example.controller;

import com.hyun.shopping_mall_example.domain.GoodsCategoryVO;
import com.hyun.shopping_mall_example.domain.GoodsVO;
import com.hyun.shopping_mall_example.service.AdminService;
import com.hyun.shopping_mall_example.utils.UploadFileUtils;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService;

    @Resource(name = "uploadPath")
    private String uploadPath;

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
    public String registerGoods(GoodsVO goodsVO, MultipartFile imgFile) throws Exception {
        String imgUploadPath = uploadPath + File.separator + "img";
        String datePath = UploadFileUtils.makePath(imgUploadPath);
        String fileName = null;
        if (imgFile.getOriginalFilename() != null && imgFile.getOriginalFilename() != "") fileName = UploadFileUtils.fileUpload(imgUploadPath, imgFile.getOriginalFilename(), imgFile.getBytes(), datePath);
//        else fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
        goodsVO.setImgUrl(File.separator + "img" + datePath + File.separator + fileName);
        goodsVO.setThumbImgUrl(File.separator + "img" + datePath + File.separator + "s" + File.separator + "s_" + fileName);
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
        model.addAttribute("goods", adminService.goodsDetail(id));
    }

    @GetMapping(value = "/goods/modify")
    public void modifyGoods(@RequestParam("id") Long id, Model model) throws Exception {
        System.out.println("Get Modify Goods");
        model.addAttribute("goods", adminService.goodsDetail(id));

        List<GoodsCategoryVO> goodsCategories = adminService.getGoodsCategory();
        model.addAttribute("goodsCategories", JSONArray.fromObject(goodsCategories));
    }

    @PostMapping(value = "/goods/modify")
    public String modifyGoods(GoodsVO goodsVO) throws Exception {
        System.out.println("Post Modify Goods");
        adminService.modifyGoods(goodsVO);
        return "redirect:/admin/index";
    }

    @PostMapping(value = "/goods/delete")
    public String deleteGoods(@RequestParam("id") Long id) throws Exception {
        System.out.println("Post Delete Goods");
        adminService.deleteGoods(id);
        return "redirect:/admin/index";
    }
}
