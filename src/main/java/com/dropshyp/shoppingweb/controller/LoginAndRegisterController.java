package com.dropshyp.shoppingweb.controller;

import com.dropshyp.shoppingweb.model.Users;
import com.dropshyp.shoppingweb.service.LoginAndRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Yilinlou
 * @date 7/10/20 9:47 下午
 * @Email:ylou7@stevens.edu
 */
@Controller
@SessionAttributes("user") //import session sent "user" to other pages
public class LoginAndRegisterController {

    @Autowired
    private LoginAndRegisterService loginAndRegisterService;


    @Autowired
    private BCryptPasswordEncoder encoder;

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
    @GetMapping("/login.html")
    public String tologin(){
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
    public String saveUser(Users users) {
//        User user_new=loginAndRegisterService.save(user);
        users.setPassword(encoder.encode(users.getPassword()));
        System.out.println(users.getUsername());
        System.out.println(users.getEmail());
        System.out.println(users.getPassword());

        loginAndRegisterService.save(users);
//        if (user_new!=null){
//            attributes.addFlashAttribute("message", "Welcome" + user_new.getName() + "Please login");
//        }
        return "index";
    }


    /**
     * @Description: login
     * @Param: [user]
     * @return: java.lang.String
     * @Author: Yilin Lou
     * @Date: 7/13/20
     */
    //之后要加入传递对象到前端页面
    @PostMapping("/login")
    public String login(Users users, final RedirectAttributes attributes,HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException, LoginException {
        try {
            Users users_check = loginAndRegisterService.findByName(users.getUsername());
            System.out.println(users_check.getUsername() + "查询的username");
            String psw_check = users_check.getPassword();
            if (encoder.matches(users.getPassword(), psw_check)) {
                System.out.println("密码验证正确");
                session.setAttribute("user", users);
                response.sendRedirect("/index.html");
            } else {
                throw new LoginException("登录失败！ 用户名或者密码错误");
            }
        } catch (Exception e) {
//            String message = "No register";
            attributes.addFlashAttribute("message",  "No register");
            return "redirect:/register";   //返回这个url 一个GetMapping

        }
        return "index";
    }


}
