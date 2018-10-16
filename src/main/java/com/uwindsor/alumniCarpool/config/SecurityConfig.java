package com.uwindsor.alumniCarpool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Suo Tian on 2018/10/16.
 */

@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

//    @Autowired
//    MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors()
            .and()
            .authorizeRequests()
                .antMatchers("/js/**","/css/**","/fonts/**","/images/**","/login", "/", "/logout").permitAll();//resources,static,templates,public下面是系统默认的静态资源搜索路径
            //.anyRequest().authenticated()//要求访问应用的所有用户都要被验证
//                .and()
//            .formLogin()
//                .loginProcessingUrl("/login")
//                .loginPage("/login").successForwardUrl("/user").permitAll()
//                .and()
//                .logout().logoutSuccessUrl("/login");
}


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        /*
        * 多种方式的authenticate, 参考https://www.programcreek.com/java-api-examples/index.php?api=org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
        * UserDetails(查询数据库得到用户名相对应的密码和权限塞到这个对象中) - UserDetailsService - AuthenticationManager(AuthenticationProvider列表中的每一个AuthenticationProvider依次验证 - 实现类ProviderManager，例如代码中的AuthenticationManagerBuilder auth，auth中存储的是http请求中的用户名和密码信息) - 验证成功后填充到Authentication对象-存储在SecurityContext（HttpSession的一个属性）中。其中AuthenticationManager之后的步骤都是Spring boot框架封装好的。
        */
        //auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
        auth.inMemoryAuthentication().withUser("admin").password(encodePassword("admin")).roles("admin");
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static String encodePassword(String password){
        return passwordEncoder().encode(password);
    }

    //BCryptPasswordEncoder is an algorithm of hashing, not encoding, therefore it provides only the hash/match method rather than the decoding method.
    public static boolean matchPassword(String password, String hashPassword){
        return passwordEncoder().matches(password, hashPassword);
    }
}