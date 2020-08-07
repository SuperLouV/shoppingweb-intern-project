package com.dropshyp.shoppingweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Yilinlou
 * @date 7/20/20 4:34 下午
 * @Email:ylou7@stevens.edu
 */

@Controller
public class IndexController {

    @RequestMapping("/index.html")
    public String visitIndex() {
        return "index";
    }

    /**
     * 访问根目录转发到首页
     * @return
     */
    @RequestMapping("/")
    public String visitIndex_2(){
        return "forward:/index.html";
    }
}
