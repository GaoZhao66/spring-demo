package com.cmb.auth.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

/**
 * @Author gaozhao
 * @创建时间 2019/12/19
 * @描述
 **/
@Component
public class MyUserDetailsService  {

//   @Bean
//    public UserDetailsService loadUserByUsername() throws UsernameNotFoundException {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user").password("123").roles("USER").build());
//        manager.createUser(User.withUsername("admin").password("123").roles("ADMIN").build());
//        return manager;
//    }

}
