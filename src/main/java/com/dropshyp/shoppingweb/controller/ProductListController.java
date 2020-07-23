package com.dropshyp.shoppingweb.controller;

import com.dropshyp.shoppingweb.service.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Yilinlou
 * @date 7/21/20 6:43 下午
 * @Email:ylou7@stevens.edu
 */

@Controller
public class ProductListController {
    @Autowired
    private ProductListService productListService;

    @GetMapping("/post-ad")
    public String post(Model model) {
        List<String> all_contact_name = productListService.findAllContact_name();
        model.addAttribute(all_contact_name);
        System.out.println(all_contact_name);
        return "post-ad";
    }

}
