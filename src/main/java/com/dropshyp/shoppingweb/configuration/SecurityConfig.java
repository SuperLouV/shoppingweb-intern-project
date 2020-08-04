package com.dropshyp.shoppingweb.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Yilinlou
 * @date 7/13/20 4:10 下午
 * @Email:ylou7@stevens.edu
 */

@Configuration   //define config
@EnableWebSecurity  //start Security
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * @Description: SpringSecurity will intercept static resources, this function used to slove this problem
     * @Param: [web]
     * @return: void
     * @Author: Yilin Lou
     * @Date: 7/13/20
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        //static resources are intercepted
        web.ignoring().antMatchers("/static/**");
    }

    /**
    * @Description: http url configuration
    * @Param: [http]
    * @return: void
    * @Author: Yilin Lou
    * @Date: 7/13/20
    */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //allow all user to visit login and index.html
//        http.authorizeRequests()
//                .antMatchers("/**").permitAll();
////                .antMatchers("/", "/login","/index","/register").permitAll();        //can be visited by all users
////                //other pages need permissions
////                .anyRequest().authenticated()
////                .and()
////                .formLogin()
////                //指定登录页是"/Login"
////                .loginPage("/login")
////                .successForwardUrl("/"); // 登入成功后，跳转至指定页面
////                //go to index after login successful
//////                .defaultSuccessUrl("/index")
////                .failureUrl("/login")
////                .permitAll()
////                .and()
////                .logout()
////                .logoutUrl("/")
////                //back to index after logout
////                .logoutSuccessUrl("/")
////                .permitAll();
//        //un-thymeleaf form can still submit
//        http.csrf().disable();
//
//        //solve Chinese messy code
////        CharacterEncodingFilter filter = new CharacterEncodingFilter();
////        filter.setEncoding("UTF-8");
////        filter.setForceEncoding(true);
////        http.addFilterBefore(filter,CsrfFilter.class);
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/suishoupai_search.do").hasRole("USER")
//                .and()
//                .formLogin()
//                .failureUrl("/login?failed=true")
//                .loginPage("/login")
//                .permitAll()
                .and()
                .logout()
                .permitAll();

    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /**
    * @Description: define encryption as BCryptPasswordEncoder
    * @Param: []
    * @return: org.springframework.security.crypto.password.PasswordEncoder
    * @Author: Yilin Lou
    * @Date: 7/13/20
    */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * @Description: 认证对象
     * @Param: [auth]
     * @return: void
     * @Author: Yilin Lou
     * @Date: 7/13/20
     */
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(systemUserService()).passwordEncoder(passwordEncoder());
//        //也可以将用户名密码写在内存，不推荐
////        auth.inMemoryAuthentication().withUser("admin").password("111111").roles("USER");
//    }

//    @Bean
//    public UserDetailsService systemUserService() {
//        return new UserLoginService();
//    }

}
