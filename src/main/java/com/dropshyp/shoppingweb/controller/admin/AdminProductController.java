package com.dropshyp.shoppingweb.controller.admin;

import com.dropshyp.shoppingweb.model.Pictures;
import com.dropshyp.shoppingweb.model.Products;
import com.dropshyp.shoppingweb.service.AdminProductService;
import com.dropshyp.shoppingweb.service.ProducService;
import com.dropshyp.shoppingweb.service.ProductListService;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Yilinlou
 * @date 8/4/20 5:13 下午
 * @Email:ylou7@stevens.edu
 */


@Controller
public class AdminProductController {

    String product_id;

    @Autowired
    private ProductListService productListService;

    @Autowired
    private AdminProductService adminProductService;

    @Autowired
    private ProducService producService;

    /**
     * @Description: visitAdminIndex
     * @Param: []
     * @return: java.lang.String
     * @Author: Yilin Lou
     * @Date: 8/14/20
     */
    @RequestMapping("/admin/index")
    public String visitAdminIndex() {
        return "/admin/frame";
    }


    /**
     * @Description: visit GoodsAdd HTML and send UUID as product_id
     * @Param: [model]
     * @return: java.lang.String
     * @Author: Yilin Lou
     * @Date: 8/14/20
     */
    @GetMapping("/admin/tgls/goodsManage/goods_add.html")
    public String visitGoodsAdd(Model model) {
        List<String> all_contact_name = productListService.findAllContact_name();
        model.addAttribute("all_contact_name", all_contact_name);
        System.out.println(all_contact_name);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println("uuid" + uuid);
        model.addAttribute("product_id", uuid);
        return "/admin/tgls/goodsManage/goods_add.html";
    }


    @PostMapping("/admin/product/productAdd")
    public String addGoods(Products products, Model model) {
        List<String> all_contact_name = productListService.findAllContact_name();
        model.addAttribute("all_contact_name", all_contact_name);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(date);
        products.setCreate_at(dateStr);
        producService.saveProduct(products);
        return "/admin/tgls/goodsManage/goods_add.html";
    }


    /**
     * @Description: upload picture
     * @Param: [file, request]
     * @return: java.util.Map
     * @Author: Yilin Lou
     * @Date: 8/13/20
     */
    @ResponseBody       //return JSON
    @RequestMapping("upload-picture")
    public Map upload(MultipartFile file, Pictures picture) {
        System.out.println("product_id :" + product_id);
        picture.setProduct_id(product_id);
        String prefix = "";
        String dateStr = "";
        OutputStream out = null;
        InputStream fileInput = null;
        try {
            if (file != null) {
                String originalName = file.getOriginalFilename();
                prefix = originalName.substring(originalName.lastIndexOf(".") + 1);
                //uuid
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                //data
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateStr = simpleDateFormat.format(date);
                File path = new File(ResourceUtils.getURL("classpath:").getPath());
                File upload = new File(path.getAbsolutePath(), "static/img/productsIMG/");
                String filepath = upload.getAbsolutePath() + "/" + dateStr + "/" + uuid + "." + prefix;
                File files = new File(filepath);
                System.out.println(filepath);
                if (!files.getParentFile().exists()) {
                    files.getParentFile().mkdirs();
                    System.out.println("getparentfile");
                }
                file.transferTo(files);
                Map<String, Object> map2 = new HashMap<>();
                Map<String, Object> map = new HashMap<>();
                map.put("code", 0);
                map.put("msg", "");
                map.put("data", map2);
                map2.put("src", upload.getAbsolutePath() + "/" + dateStr + "/" + uuid + "." + prefix);
                System.out.println(map);
                picture.setPicture_url(filepath);
                Pictures picture1 = adminProductService.save(picture);
                return map;
            }
        } catch (Exception e) {
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (fileInput != null) {
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "");
        return map;

    }

    /**
     * @Description: ajax url used to send product_id from front-end
     * @Param: [request]
     * @return: void
     * @Author: Yilin Lou
     * @Date: 8/14/20
     */
    @ResponseBody
    @RequestMapping(value = "product/getProduct_id", method = RequestMethod.POST)
    public void get_productId(HttpServletRequest request) {
        String id = request.getParameter("product_id");
        this.product_id = id;
    }


}
