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
import org.springframework.web.multipart.MultipartHttpServletRequest;


import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

//    @RequestMapping("admin/product/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file,Model model) {
        // 原始图片名称
        System.out.println("test");
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();

        // 存储路径
//        String saveFilePath = "D://新建文件夹 (4)//house//src//main//webapp//housepic";
//        // 新的图片名称
//        String newFileName = UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
//        // 新图片
//        File newFile = new File(saveFilePath + "\\" + newFileName);
//        // 将内存中的数据写入磁盘
//        newpic.transferTo(newFile);
//        // 将路径名存入全局变量mynewpic
//        mynewpic = "./housepic/"+newFileName;
        return "/admin/tgls/goodsManage/goods_add.html";
    }


    @RequestMapping("admin/product/uploadFile")
    public void insert(HttpServletRequest request, HttpServletResponse response
            , @RequestParam("file") MultipartFile[] file) throws Exception{
        System.out.println("test");
        if(file!=null&&file.length>0){
            //组合image名称，“;隔开”
            List<String> fileName =new ArrayList<String>();

            try {
                for (int i = 0; i < file.length; i++) {
                    if (!file[i].isEmpty()) {
                        System.out.println(file[i]);

                        //上传文件，随机名称，";"分号隔开
//                        fileName.add(FileUtil.uploadImage(request, "/upload/"+TimeUtils.formateString(new Date(), "yyyy-MM-dd")+"/", file[i], true));
                    }
                }

                //上传成功
                if(fileName!=null&&fileName.size()>0){
                    System.out.println("上传成功！");
//                    Constants.printJson(response, fileName);;
                }else {
//                    Constants.printJson(response, "上传失败！文件格式错误！");
                }
            } catch (Exception e) {
                e.printStackTrace();
//                Constants.printJson(response, "上传出现异常！异常出现在：class.UploadController.insert()");
            }
        }
//        else {
//            Constants.printJson(response, "没有检测到文件！");
//        }
    }



}
