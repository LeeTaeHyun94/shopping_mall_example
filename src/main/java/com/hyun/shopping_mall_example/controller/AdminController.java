package com.hyun.shopping_mall_example.controller;

import com.hyun.shopping_mall_example.domain.GoodsCategoryVO;
import com.hyun.shopping_mall_example.domain.GoodsVO;
import com.hyun.shopping_mall_example.service.AdminService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
    public String registerGoods(GoodsVO goodsVO, MultipartFile imgFile) throws Exception {
        adminService.registerGoods(goodsVO, imgFile);
        return "redirect:/admin/index";
    }

    @PostMapping(value = "/goods/ckupload")
    public void CKEditorFileUpload(HttpServletResponse response, @RequestParam MultipartFile upload) throws Exception {
        System.out.println("Post CKEditor File Upload");
        JSONObject ret = adminService.CKEditorFileUpload(upload);
        PrintWriter printWriter = null;
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        try {
            printWriter = response.getWriter();
            printWriter.println(ret);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (printWriter != null) printWriter.close();
        }
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
    public String modifyGoods(GoodsVO goodsVO, MultipartFile imgFile, HttpServletRequest httpServletRequest) throws Exception {
        System.out.println("Post Modify Goods");
        adminService.modifyGoods(goodsVO, imgFile, httpServletRequest);
        return "redirect:/admin/index";
    }

    @PostMapping(value = "/goods/delete")
    public String deleteGoods(@RequestParam("id") Long id) throws Exception {
        System.out.println("Post Delete Goods");
        adminService.deleteGoods(id);
        return "redirect:/admin/index";
    }
}
