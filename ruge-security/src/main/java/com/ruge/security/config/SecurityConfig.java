package com.ruge.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: security 配置
 * @date 2020/6/8 22:39
 */

@SpringBootConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 角色继承
     *
     * @return {@link RoleHierarchy}
     */
    @Bean
    RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();
        hierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER\n" +
                " ROLE_USER > ROLE_ANONYMOUS\n");
        return hierarchy;
    }

    /**
     * {@link PasswordEncoderFactories} 密码加密工厂
     * {@link BCryptPasswordEncoder} 默认加密方式
     * {@link BCryptPasswordEncoder#encode(CharSequence)}  密码加密
     * {@link BCryptPasswordEncoder#matches(CharSequence, String)}}  密码匹配
     *
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 一个基本的SecurityBuilder
     *
     * @param auth {@link AuthenticationManagerBuilder}
     * @throws Exception {@link Exception}
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("123456")
                .roles("admin")
                .and()
                .withUser("ruge.wu")
                .password("845376854")
                .roles("user");
    }

    /**
     * Override this method to configure {@link WebSecurity}. For example, if you wish to
     * ignore certain requests.
     *
     * @param web
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/js/**", "/css/**", "/fonts/**", "/images/**");
    }

    /**
     * Override this method to configure the {@link HttpSecurity}. Typically subclasses
     * should not invoke this method by calling super as it may override their
     * configuration. The default configuration is:
     *
     * <pre>
     * http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
     * </pre>
     *
     * @param http the {@link HttpSecurity} to modify
     * @throws Exception if an error occurs
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/lyear_pages_login.html")
                .usernameParameter("username")   /*自定义用户名属性*/
                .passwordParameter("password")  /*自定义密码属性*/
                //.successForwardUrl("/index.html")   /*服务端跳转*/
                //.defaultSuccessUrl("/index.html")   /*重定向地址*/
                .successHandler((rep, resp, auth) -> {   /*登录成功的处理器*/
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    Object principal = auth.getPrincipal();
                    Map map = new HashMap<>();
                    map.put("msg", "登录成功");
                    map.put("principal", principal);
                    String s = new ObjectMapper().writeValueAsString(map);
                    out.write(s);
                    out.flush();
                    out.close();
                })
                .failureHandler((rep, resp, exception) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    Map map = new HashMap<>();
                    if (exception instanceof LockedException) {
                        map.put("msg", "账户被锁定，请联系管理员!");
                    } else if (exception instanceof CredentialsExpiredException) {
                        map.put("msg", "密码过期，请联系管理员!");
                    } else if (exception instanceof AccountExpiredException) {
                        map.put("msg", "账户过期，请联系管理员!");
                    } else if (exception instanceof DisabledException) {
                        map.put("msg", "账户被禁用，请联系管理员!");
                    } else if (exception instanceof BadCredentialsException) {
                        map.put("msg", "用户名或者密码输入错误，请重新输入!");
                    }
                    out.write(new ObjectMapper().writeValueAsString(map));
                    out.flush();
                    out.close();
                })
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
                .logoutSuccessHandler((req, resp, authentication) -> {
                            resp.setContentType("application/json;charset=utf-8");
                            Map map = new HashMap<>();
                            map.put("msg", "注销成功");
                            PrintWriter out = resp.getWriter();
                            out.write(new ObjectMapper().writeValueAsString(map));
                            out.flush();
                            out.close();
                        }
                )
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll()
                .and().csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((req, resp, exception) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    resp.setStatus(401);
                    PrintWriter out = resp.getWriter();
                    Map map = new HashMap<>();
                    if (exception instanceof InsufficientAuthenticationException) {
                        map.put("msg", "您无权操作，请登陆!");
                    }
                    out.write(new ObjectMapper().writeValueAsString(map));
                    out.flush();
                    out.close();
                });


    }
}
