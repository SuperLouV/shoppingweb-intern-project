package com.dropshyp.shoppingweb.controller;

import com.dropshyp.shoppingweb.domain.User;
import com.dropshyp.shoppingweb.service.LoginAndRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Yilinlou
 * @date 7/10/20 9:47 下午
 * @Email:ylou7@stevens.edu
 */
@Controller

public class LoginAndRegisterController {

    @Autowired
    private LoginAndRegisterService loginAndRegisterService;

    /**
     * @Description: link to login.html
     * @Param: []
     * @return: java.lang.String
     * @Author: Yilin Lou
     * @Date: 7/10/20
     */
    @GetMapping("/register")
    public String register() {
        return "login";
    }

    /**
     * @Description: insert new user to table (user)
     * @Param: [user]
     * @return: java.lang.String
     * @Author: Yilin Lou
     * @Date: 7/11/20
     */
    @PostMapping("/saveUser")
    public String login(User user) {
//        User user_new=loginAndRegisterService.save(user);
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
//        user.setId(23);
        System.out.println(user.getId());

        loginAndRegisterService.save(user);
//        if (user_new!=null){
//            attributes.addFlashAttribute("message", "Welcome" + user_new.getName() + "Please login");
//        }
        return "index";
    }
}
