package com.dropshyp.shoppingweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yilinlou
 * @date 7/5/20 11:26 下午
 * @Email:ylou7@stevens.edu
 */
//http://127.0.0.1:8080/hello


@Controller
public class Hello {
    @RequestMapping("/hello")
    public String hello() {
        return "login";
    }



}
