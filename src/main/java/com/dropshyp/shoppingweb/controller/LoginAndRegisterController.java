package com.dropshyp.shoppingweb.controller;

import com.dropshyp.shoppingweb.domain.User;
import com.dropshyp.shoppingweb.service.LoginAndRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
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

    /**
     * @Description: insert new user to table (user)
     * @Param: [user]
     * @return: java.lang.String
     * @Author: Yilin Lou
     * @Date: 7/11/20
     */
    @PostMapping("/saveUser")
    public String saveUser(User user) {
//        User user_new=loginAndRegisterService.save(user);
        user.setPassword(encoder.encode(user.getPassword()));

        loginAndRegisterService.save(user);
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
    public String login(User user){
        User user_check=loginAndRegisterService.findByName(user.getName());
        if (user_check!=null){
            String psw_check=user_check.getPassword();
            if (encoder.matches(user.getPassword(),psw_check)){
                System.out.println("密码验证正确");
            }else {
                System.out.println("密码错误");
            }
        }else {
            System.out.println("该用户没注册");
        }
        return "index";
    }


}
