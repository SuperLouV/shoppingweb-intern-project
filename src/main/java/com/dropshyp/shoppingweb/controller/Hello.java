package com.dropshyp.shoppingweb.controller;

import com.dropshyp.shoppingweb.service.ProductListService;
import com.dropshyp.shoppingweb.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Yilinlou
 * @date 7/5/20 11:26 下午
 * @Email:ylou7@stevens.edu
 */
//http://127.0.0.1:8080/hello


@Controller
public class Hello {
    @Autowired
    ProductListService productListService;

    @RequestMapping("/hello")
    public String hello() {
        return "login";
    }


    private static int ExpireTime = 60;   // redis中存储的过期时间60s

    @Resource
    private RedisUtil redisUtil;





}
