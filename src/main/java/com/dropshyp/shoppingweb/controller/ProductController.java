package com.dropshyp.shoppingweb.controller;

import com.dropshyp.shoppingweb.model.Products;
import com.dropshyp.shoppingweb.service.CategoryService;
import com.dropshyp.shoppingweb.service.ProducService;
import com.dropshyp.shoppingweb.service.ProductListService;
import com.dropshyp.shoppingweb.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private CategoryService categoryService;

    //import redis
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisUtil.redisMap redisMap;


    /**
     * @Description: return Products as pages(15 items per page)
     * @Param: [pageable, model]
     * @return: java.lang.String
     * @Author: Yilin Lou
     * @Date: 7/24/20
     */
    @GetMapping("/products")
    public String allProductByPages(@PageableDefault(size = 12, sort = {"product_id"}, direction = Sort.Direction.DESC) Pageable pageable,
                                    Model model) {
        Page<Products> page1 = producService.findAllByPages(pageable);
        model.addAttribute("page", page1);      //get "page" in the front page;
        return "#";
    }


    /**
     * @param pageable,categories_name
     * @param model
     * @param categories
     * @return
     * @Description: return Products as pages(15 items per page) by categories
     */
    @GetMapping("/products/{categories}")
    public String findAllByCategories(@PageableDefault(size = 12, sort = {"product_id"}, direction = Sort.Direction.DESC) Pageable pageable,
                                      Model model, @PathVariable String categories) {
        Page<Products> page2 = producService.findByCategory_id(categories, pageable);
        model.addAttribute("page", page2);
        return "#";
    }

    @PostMapping("/saveProducts")
    public void saveProduct() {

    }

    /**
    * @Description: showAllProducts on list-view1.html ,send categories data and products data
    * @Param: [model]
    * @return: java.lang.String
    * @Author: Yilin Lou
    * @Date: 8/19/20
    */
    @PostMapping ("showAllProducts")
    public String showAllProducts(Model model) {
        HashMap<String, List<String>> category_map;
        List<String> list_mainCategory=getAllMainCategory();
        category_map=getAllSubCategory(list_mainCategory);
        System.out.println(category_map);
        model.addAttribute("category_map",category_map);
        return "list-view1.html";
    }

    /**
    * @Description: getAllMainCategory
    * @Param: []
    * @return: java.util.List<java.lang.String>
    * @Author: Yilin Lou
    * @Date: 8/19/20
    */
    public List<String> getAllMainCategory() {
        List<String> allMainCategory = new ArrayList<>();
        allMainCategory = categoryService.findDistinctByMain_category();
        return allMainCategory;
    }

    
    /**
    * @Description: getAllSubCategory
    * @Param: [allCategory]
    * @return: java.util.HashMap<java.lang.String,java.util.List<java.lang.String>>
    * @Author: Yilin Lou
    * @Date: 8/19/20
    */
    public HashMap<String, List<String>> getAllSubCategory(List<String> allCategory) {
        HashMap<String,List<String>> map=new HashMap<>();
        for (String mainCategory : allCategory) {
            List<String> subCategory=categoryService.findSub_category(mainCategory);
            map.put(mainCategory,subCategory);
        }
        return map;
    }


}
