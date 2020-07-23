package com.dropshyp.shoppingweb.controller;

import com.dropshyp.shoppingweb.model.Users;
import com.dropshyp.shoppingweb.service.LoginAndRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
//    @GetMapping("/register")
//    public String register() {
//        return "login";
//    }

    /**
     * @Description: insert new user to table (user)
     * @Param: [user]
     * @return: java.lang.String
     * @Author: Yilin Lou
     * @Date: 7/11/20
     */
//    @PostMapping("/saveUser")
//    public String saveUser(Users users) {
////        User user_new=loginAndRegisterService.save(user);
//        users.setPassword(encoder.encode(users.getPassword()));
//
//        loginAndRegisterService.save(users);
////        if (user_new!=null){
////            attributes.addFlashAttribute("message", "Welcome" + user_new.getName() + "Please login");
////        }
//        return "index";
//    }

    
    /**
    * @Description: login
    * @Param: [user]
    * @return: java.lang.String
    * @Author: Yilin Lou
    * @Date: 7/13/20
    */
    //之后要加入传递对象到前端页面
//    @PostMapping("/login")
//    public String login(Users users){
//        Users users_check = loginAndRegisterService.findByName(users.getUsername());
//        if (users_check != null){
//            String psw_check = users_check.getPassword();
//            if (encoder.matches(users.getPassword(), psw_check)){
//                System.out.println("密码验证正确");
//            }else {
//                System.out.println("密码错误");
//            }
//        }else {
//            System.out.println("该用户没注册");
//        }
//        return "index";
//    }


}
