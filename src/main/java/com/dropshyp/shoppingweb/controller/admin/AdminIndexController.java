package com.dropshyp.shoppingweb.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Yilinlou
 * @date 8/4/20 5:13 下午
 * @Email:ylou7@stevens.edu
 */



@Controller
public class AdminIndexController {
    @RequestMapping("/admin/index")
    public String toIndex() {
        return "/admin/frame";
    }


    @GetMapping("/admin/tgls/goodsManage/goods_add.html")
    public String goods_add() {
        System.out.println("test");
        System.out.println("跳转");
        return "/admin/tgls/goodsManage/goods_add.html";
    }


}
