package com.hyun.shopping_mall_example.service;

import com.hyun.shopping_mall_example.domain.GoodsCategoryVO;
import com.hyun.shopping_mall_example.domain.GoodsVO;
import com.hyun.shopping_mall_example.dto.GoodsDetailDTO;
import com.hyun.shopping_mall_example.persistence.AdminDAO;
import com.hyun.shopping_mall_example.utils.UploadFileUtils;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO;
    private String uploadPath;

    public AdminServiceImpl(AdminDAO adminDAO, String uploadPath) {
        this.adminDAO = adminDAO;
        this.uploadPath = uploadPath;
    }

    @Override
    public List<GoodsCategoryVO> getGoodsCategory() throws Exception {
        return adminDAO.getGoodsCategory();
    }

    @Override
    public void registerGoods(GoodsVO goodsVO, MultipartFile imgFile) throws Exception {
        String imgUploadPath = uploadPath + File.separator + "img";
        String datePath = UploadFileUtils.makePath(imgUploadPath);
        String fileName = null;
        if (imgFile.getOriginalFilename() != null && imgFile.getOriginalFilename() != "") fileName = UploadFileUtils.fileUpload(imgUploadPath, imgFile.getOriginalFilename(), imgFile.getBytes(), datePath);
        else fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
        goodsVO.setImgUrl(File.separator + "img" + datePath + File.separator + fileName);
        goodsVO.setThumbImgUrl(File.separator + "img" + datePath + File.separator + "s" + File.separator + "s_" + fileName);
        adminDAO.registerGoods(goodsVO);
    }

    @Override
    public List<GoodsVO> goodsList() throws Exception {
        return adminDAO.goodsList();
    }

    @Override
    public JSONObject CKEditorFileUpload(MultipartFile uploadedFile) throws Exception {
        String fileUploadPath = uploadPath + File.separator + "ckUpload";
        File fileUploadDirectory = new File(fileUploadPath);
        if (!fileUploadDirectory.exists()) fileUploadDirectory.mkdir();
        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + uploadedFile.getOriginalFilename();
        File target = new File(fileUploadPath, File.separator + fileName);
        FileCopyUtils.copy(uploadedFile.getBytes(), target);

        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("uploaded", 1);
        jsonObject.accumulate("fileName", fileName);
        jsonObject.accumulate("url", "/ckUpload/" + fileName);
        return jsonObject;
    }

    @Override
    public GoodsVO getGoods(Long id) throws Exception {
        return adminDAO.getOneGoods(id);
    }

    @Override
    public GoodsDetailDTO goodsDetail(Long id) throws Exception {
        GoodsDetailDTO goods = adminDAO.goodsDetail(id);
        Long firstCategoryId = goods.getCategoryIdRef();
        if (firstCategoryId != null) goods.setFirstCategoryName(adminDAO.getGoodsCategoryName(firstCategoryId));
        else goods.setCategoryIdRef(0L);
        return goods;
    }

    @Override
    public void modifyGoods(GoodsVO goodsVO, MultipartFile imgFile, HttpServletRequest httpServletRequest) throws Exception {
        if (imgFile.getOriginalFilename() != null && imgFile.getOriginalFilename() != "") {
            new File(uploadPath + httpServletRequest.getParameter("imgUrl")).delete();
            new File(uploadPath + httpServletRequest.getParameter("thumbImgUrl")).delete();

            String imgUploadPath = uploadPath + File.separator + "img";
            String datePath = UploadFileUtils.makePath(imgUploadPath);
            String fileName = UploadFileUtils.fileUpload(imgUploadPath, imgFile.getOriginalFilename(), imgFile.getBytes(), datePath);

            goodsVO.setImgUrl(File.separator + "img" + datePath + File.separator + fileName);
            goodsVO.setThumbImgUrl(File.separator + "img" + datePath + File.separator + "s" + File.separator + "s_" + fileName);
        }
        else {
            goodsVO.setImgUrl(httpServletRequest.getParameter("imgUrl"));
            goodsVO.setThumbImgUrl(httpServletRequest.getParameter("thumbImgUrl"));
        }
        adminDAO.modifyGoods(goodsVO);
    }

    @Override
    public void deleteGoods(Long id) throws Exception {
        adminDAO.deleteGoods(id);
    }
}
