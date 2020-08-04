package com.dropshyp.shoppingweb.controller.admin;

import com.dropshyp.shoppingweb.service.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Yilinlou
 * @date 8/4/20 4:55 下午
 * @Email:ylou7@stevens.edu
 */

@RequestMapping("/admin")
@Controller
public class AdminProductController {
    @Autowired
    private ProductListService productListService;

    @GetMapping("/goods_add")
    public String get(Model model) {
        /**
         * @Description: all_contact_name from all suppliers
         * @Param: [model]
         * @return: java.lang.String
         * @Author: Yilin Lou
         * @Date: 7/23/20
         */
        List<String> all_contact_name = productListService.findAllContact_name();
        model.addAttribute("all_contact_name",all_contact_name);
        System.out.println(all_contact_name);
        return "/admin/frame.html";
//        return "/admin/tgls/goodsManage/goods_add";
    }
}
