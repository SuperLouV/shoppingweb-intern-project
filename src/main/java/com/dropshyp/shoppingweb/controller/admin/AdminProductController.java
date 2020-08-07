package com.dropshyp.shoppingweb.controller.admin;

import com.dropshyp.shoppingweb.model.Products;
import com.dropshyp.shoppingweb.service.ProductListService;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Yilinlou
 * @date 8/4/20 5:13 下午
 * @Email:ylou7@stevens.edu
 */


@Controller
public class AdminProductController {
    @Autowired
    private ProductListService productListService;

    @RequestMapping("/admin/index")
    public String visitAdminIndex() {
        return "/admin/frame";
    }


    @GetMapping("/admin/tgls/goodsManage/goods_add.html")
    public String visitGoodsAdd(Model model) {
        List<String> all_contact_name = productListService.findAllContact_name();
        model.addAttribute("all_contact_name", all_contact_name);
        System.out.println(all_contact_name);
        return "/admin/tgls/goodsManage/goods_add.html";
    }


    @PostMapping("/admin/product/productAdd")
    public String addGoods(Products products, Model model) {
        List<String> all_contact_name = productListService.findAllContact_name();
        model.addAttribute("all_contact_name", all_contact_name);
        System.out.println(products.getName());
        return "/admin/tgls/goodsManage/goods_add.html";
    }

    @PostMapping("/admin/product/uploadFile")
    public void uploadFile(@RequestParam("file") MultipartFile newpic, HttpServletRequest request)
            throws IllegalStateException, IOException {
        System.out.println("upload pictures");
        // 原始图片名称
//        String oldFileName = newpic.getOriginalFilename(); // 获取上传文件的原名
//        // 存储路径
//        String saveFilePath = "../resources/static/img";
//        // 新的图片名称
//        String newFileName = Math.random() + oldFileName.substring(oldFileName.lastIndexOf("."));
//        // 新图片
//        System.out.println(newFileName);
//        File newFile = new File(saveFilePath + "\\" + newFileName);
        // 将内存中的数据写入磁盘
//        newpic.transferTo(newFile);
        // 将路径名存入全局变量mynewpic
//        mynewpic = "./housepic/"+newFileName;
    }


}
