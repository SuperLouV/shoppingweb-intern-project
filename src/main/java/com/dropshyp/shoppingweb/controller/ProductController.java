package com.dropshyp.shoppingweb.controller;

import com.dropshyp.shoppingweb.model.Products;
import com.dropshyp.shoppingweb.service.ProducService;
import com.dropshyp.shoppingweb.service.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Yilinlou
 * @date 7/24/20 5:06 下午
 * @Email:ylou7@stevens.edu
 * @Description: Control all products data
 */

@Controller
public class ProductController {

    @Autowired
    private ProductListService productListService;

    @Autowired
    private ProducService producService;

    
    /**
    * @Description: return Products as pages(15 items per page)
    * @Param: [pageable, model]
    * @return: java.lang.String
    * @Author: Yilin Lou
    * @Date: 7/24/20
    */
    @GetMapping("/products")
    public String allProductByPages(@PageableDefault(size = 12, sort = {"product_id"}, direction = Sort.Direction.DESC) Pageable pageable,
                                    Model model){
        Page<Products> page1 = producService.findAllByPages(pageable);
        model.addAttribute("page", page1);      //get "page" in the front page;
        return "#";
    }


    /**
     * @Description: return Products as pages(15 items per page) by categories
     * @param pageable
     * @param model
     * @param categories
     * @return
     */
//    @GetMapping("/products/{categories}")
//    public String findAllByCategories(@PageableDefault(size = 12, sort = {"product_id"}, direction = Sort.Direction.DESC) Pageable pageable,
//                                      Model model, @PathVariable String categories){
//        Page<Products> page2=producService.findAllByCategories(categories);
//        model.addAttribute("page",page2);
//        return "#";
//
//    }

}
